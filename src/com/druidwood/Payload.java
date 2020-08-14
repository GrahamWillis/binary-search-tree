package com.druidwood;

class Payload implements Comparable<Payload> {
    private Integer sample;

    Payload(Integer sample) {
        this.sample = sample;
    }

    @Override
    public int compareTo(Payload o) {
        return this.sample.compareTo(o.sample);
    }

    @Override
    public String toString() {
        return "Payload{" +
                "sample=" + sample +
                '}';
    }
}
