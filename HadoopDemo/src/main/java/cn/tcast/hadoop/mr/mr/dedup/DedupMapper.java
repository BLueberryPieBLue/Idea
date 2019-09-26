package cn.tcast.hadoop.mr.mr.dedup;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class DedupMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

	private static Text field = new Text();
	// <0,2018-3-3 c><11,2018-3-4 d>
	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		field = value;
		context.write(field, NullWritable.get());
	}
	// <2018-3-3 c,null> <2018-3-4 d,null>
}
