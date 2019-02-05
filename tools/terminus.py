import matplotlib.pylab as plt
import datetime
import re
import sys
import os
from time import time
from optparse import OptionParser

title = ""
y_label = "time in nanoseconds"
x_label = "n"


def plot(x_values, y_values):
    for x, y in zip(x_values, y_values):
        plt.plot(x, y, "ro")
        plt.plot(x, y)

    plt.xlabel(x_label)
    plt.ylabel(y_label)

    plt.title(title)

    timestamp = datetime.datetime.fromtimestamp(time()).strftime('%d-%m-%Y-%H-%M-%S')
    plt.savefig(f"plot-{timestamp}.png", bbox_inches='tight')


def plot_from_file(filename):

    with open(filename, 'r') as f:
        lines = f.readlines()
        if len(lines) == 2:
            x_values, y_values = convert_string_input_to_list(lines[0]), convert_string_input_to_list(lines[1])
            plot(x_values, y_values)
        else:
            exit(f'{filename} isn\'t formatted correctly.')


def set_parser(prs):
    prs.add_option("-t", "--set_title", type="string", help="set title of figure", dest="t")
    prs.add_option("-x", "--x_values", type="string", help="x values, \"[a, b, c], [d, e, f]\"", dest="x")
    prs.add_option("-y", "--y_values", type="string", help="y values, \"[a, b, c], [d, e, f]\"", dest="y")
    prs.add_option("--set_ylabel", type="string", help="sets a label on the y axis", dest="yl")
    prs.add_option("--set_xlabel", type="string", help="sets a label on the x axis", dest="xl")
    prs.add_option("-f", "--file", type="string", help="input from file. \n "
                                                       "1st line (x): [a, b, c], [d, e, f]...\n"
                                                       "2nd line (y): [a, b, c], [d, e, f]...", dest="file")


def convert_string_input_to_list(strng):
    return [[float(j) for j in i[1:len(i)-1].split(",")] for i in re.findall("\[.*?\]", strng)]


def main():
    pass


if __name__ == '__main__':
    if len(sys.argv) > 1:
        parser = OptionParser()
        set_parser(parser)

        opts, args = parser.parse_args()
        if opts.t:
            title = opts.t
        if opts.yl:
            y_label = opts.yl
        if opts.xl:
            x_label = opts.xl

        if opts.file:
            plot_from_file(opts.file)

        if opts.x and opts.y:
            x, y = convert_string_input_to_list(opts.x), convert_string_input_to_list(opts.y)
            if len(x) == len(y):
                plot(x, y)
    else:
        main()
