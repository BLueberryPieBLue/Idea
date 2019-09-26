package cn.tcast.hadoop.mr.mr.dedup;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DedupReducer extends Reducer<Text, NullWritable, Text, NullWritable> {
	// <2018-3-3 c,null> <2018-3-4 d,null><2018-3-4 d,null>
	@Override
	protected void reduce(Text key, Iterable<NullWritable> values, Context context)
			throws IOException, InterruptedException {
		context.write(key, NullWritable.get());
	}
}
