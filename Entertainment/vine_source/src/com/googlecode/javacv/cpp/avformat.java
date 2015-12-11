// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.LongPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

public class avformat
{
    public static class AVChapter extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native long end();

        public native AVChapter end(long l);

        public native int id();

        public native AVChapter id(int i);

        public native AVChapter metadata(avutil.AVDictionary avdictionary);

        public native avutil.AVDictionary metadata();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVChapter position(int i)
        {
            return (AVChapter)super.position(i);
        }

        public native long start();

        public native AVChapter start(long l);

        public native AVChapter time_base(avutil.AVRational avrational);

        public native avutil.AVRational time_base();

        static 
        {
            Loader.load();
        }

        public AVChapter()
        {
            allocate();
        }

        public AVChapter(int i)
        {
            allocateArray(i);
        }

        public AVChapter(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVCodecTag extends Pointer
    {

        public AVCodecTag()
        {
        }

        public AVCodecTag(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFormatContext extends Pointer
    {

        public static final int AVFMT_FLAG_CUSTOM_IO = 128;
        public static final int AVFMT_FLAG_DISCARD_CORRUPT = 256;
        public static final int AVFMT_FLAG_GENPTS = 1;
        public static final int AVFMT_FLAG_IGNDTS = 8;
        public static final int AVFMT_FLAG_IGNIDX = 2;
        public static final int AVFMT_FLAG_KEEP_SIDE_DATA = 0x40000;
        public static final int AVFMT_FLAG_MP4A_LATM = 32768;
        public static final int AVFMT_FLAG_NOBUFFER = 64;
        public static final int AVFMT_FLAG_NOFILLIN = 16;
        public static final int AVFMT_FLAG_NONBLOCK = 4;
        public static final int AVFMT_FLAG_NOPARSE = 32;
        public static final int AVFMT_FLAG_PRIV_OPT = 0x20000;
        public static final int AVFMT_FLAG_SORT_DTS = 0x10000;
        public static final int FF_FDEBUG_TS = 1;
        public static final int RAW_PACKET_BUFFER_SIZE = 0x2625a0;

        private native void allocate();

        private native void allocateArray(int i);

        public native int audio_codec_id();

        public native AVFormatContext audio_codec_id(int i);

        public native int audio_preload();

        public native AVFormatContext audio_preload(int i);

        public native avutil.AVClass av_class();

        public native int avio_flags();

        public native AVFormatContext avio_flags(int i);

        public native int avoid_negative_ts();

        public native AVFormatContext avoid_negative_ts(int i);

        public native int bit_rate();

        public native AVFormatContext bit_rate(int i);

        public native PointerPointer chapters();

        public native AVChapter chapters(int i);

        public native AVFormatContext chapters(int i, AVChapter avchapter);

        public native int correct_ts_overflow();

        public native AVFormatContext correct_ts_overflow(int i);

        public native int ctx_flags();

        public native AVFormatContext ctx_flags(int i);

        public native long data_offset();

        public native AVFormatContext data_offset(long l);

        public native int debug();

        public native AVFormatContext debug(int i);

        public native long duration();

        public native AVFormatContext duration(long l);

        public native int duration_estimation_method();

        public native AVFormatContext duration_estimation_method(int i);

        public native int error_recognition();

        public native AVFormatContext error_recognition(int i);

        public native byte filename(int i);

        public native BytePointer filename();

        public native AVFormatContext filename(int i, byte byte0);

        public native int flags();

        public native AVFormatContext flags(int i);

        public native int flush_packets();

        public native AVFormatContext flush_packets(int i);

        public native int fps_probe_size();

        public native AVFormatContext fps_probe_size(int i);

        public native AVFormatContext iformat(AVInputFormat avinputformat);

        public native AVInputFormat iformat();

        public native AVFormatContext interrupt_callback(AVIOInterruptCB aviointerruptcb);

        public native AVIOInterruptCB interrupt_callback();

        public native int io_repositioned();

        public native AVFormatContext io_repositioned(int i);

        public native BytePointer key();

        public native int keylen();

        public native AVFormatContext keylen(int i);

        public native int max_analyze_duration();

        public native AVFormatContext max_analyze_duration(int i);

        public native int max_chunk_duration();

        public native AVFormatContext max_chunk_duration(int i);

        public native int max_chunk_size();

        public native AVFormatContext max_chunk_size(int i);

        public native int max_delay();

        public native AVFormatContext max_delay(int i);

        public native int max_index_size();

        public native AVFormatContext max_index_size(int i);

        public native int max_picture_buffer();

        public native AVFormatContext max_picture_buffer(int i);

        public native AVFormatContext metadata(avutil.AVDictionary avdictionary);

        public native avutil.AVDictionary metadata();

        public native int nb_chapters();

        public native AVFormatContext nb_chapters(int i);

        public native int nb_programs();

        public native AVFormatContext nb_programs(int i);

        public native int nb_streams();

        public native AVFormatContext nb_streams(int i);

        public native long offset();

        public native AVFormatContext offset(long l);

        public native AVFormatContext offset_timebase(avutil.AVRational avrational);

        public native avutil.AVRational offset_timebase();

        public native AVFormatContext oformat(AVOutputFormat avoutputformat);

        public native AVOutputFormat oformat();

        public native AVFormatContext packet_buffer(AVPacketList avpacketlist);

        public native AVPacketList packet_buffer();

        public native AVFormatContext packet_buffer_end(AVPacketList avpacketlist);

        public native AVPacketList packet_buffer_end();

        public native int packet_size();

        public native AVFormatContext packet_size(int i);

        public native AVFormatContext parse_queue(AVPacketList avpacketlist);

        public native AVPacketList parse_queue();

        public native AVFormatContext parse_queue_end(AVPacketList avpacketlist);

        public native AVPacketList parse_queue_end();

        public native AVFormatContext pb(AVIOContext aviocontext);

        public native AVIOContext pb();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVFormatContext position(int i)
        {
            return (AVFormatContext)super.position(i);
        }

        public native Pointer priv_data();

        public native AVFormatContext priv_data(Pointer pointer);

        public native int probesize();

        public native AVFormatContext probesize(int i);

        public native PointerPointer programs();

        public native AVFormatContext programs(int i, AVProgram avprogram);

        public native AVProgram programs(int i);

        public native AVFormatContext raw_packet_buffer(AVPacketList avpacketlist);

        public native AVPacketList raw_packet_buffer();

        public native AVFormatContext raw_packet_buffer_end(AVPacketList avpacketlist);

        public native AVPacketList raw_packet_buffer_end();

        public native int raw_packet_buffer_remaining_size();

        public native AVFormatContext raw_packet_buffer_remaining_size(int i);

        public native int seek2any();

        public native AVFormatContext seek2any(int i);

        public native int skip_initial_bytes();

        public native AVFormatContext skip_initial_bytes(int i);

        public native long start_time();

        public native AVFormatContext start_time(long l);

        public native long start_time_realtime();

        public native AVFormatContext start_time_realtime(long l);

        public native PointerPointer streams();

        public native AVFormatContext streams(int i, AVStream avstream);

        public native AVStream streams(int i);

        public native int subtitle_codec_id();

        public native AVFormatContext subtitle_codec_id(int i);

        public native int ts_id();

        public native AVFormatContext ts_id(int i);

        public native int use_wallclock_as_timestamps();

        public native AVFormatContext use_wallclock_as_timestamps(int i);

        public native int video_codec_id();

        public native AVFormatContext video_codec_id(int i);

        static 
        {
            Loader.load();
        }

        public AVFormatContext()
        {
            allocate();
        }

        public AVFormatContext(int i)
        {
            allocateArray(i);
        }

        public AVFormatContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFrac extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native long den();

        public native AVFrac den(long l);

        public native long num();

        public native AVFrac num(long l);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVFrac position(int i)
        {
            return (AVFrac)super.position(i);
        }

        public native long val();

        public native AVFrac val(long l);

        static 
        {
            Loader.load();
        }

        public AVFrac()
        {
            allocate();
        }

        public AVFrac(int i)
        {
            allocateArray(i);
        }

        public AVFrac(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVIOContext extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native avutil.AVClass av_class();

        public native BytePointer buf_end();

        public native AVIOContext buf_end(BytePointer bytepointer);

        public native BytePointer buf_ptr();

        public native AVIOContext buf_ptr(BytePointer bytepointer);

        public native BytePointer buffer();

        public native AVIOContext buffer(BytePointer bytepointer);

        public native int buffer_size();

        public native AVIOContext buffer_size(int i);

        public native long bytes_read();

        public native AVIOContext bytes_read(long l);

        public native long checksum();

        public native AVIOContext checksum(long l);

        public native BytePointer checksum_ptr();

        public native AVIOContext checksum_ptr(BytePointer bytepointer);

        public native int direct();

        public native AVIOContext direct(int i);

        public native int eof_reached();

        public native AVIOContext eof_reached(int i);

        public native int error();

        public native AVIOContext error(int i);

        public native int max_packet_size();

        public native AVIOContext max_packet_size(int i);

        public native long maxsize();

        public native AVIOContext maxsize(long l);

        public native int must_flush();

        public native AVIOContext must_flush(int i);

        public native Pointer opaque();

        public native AVIOContext opaque(Pointer pointer);

        public native long pos();

        public native AVIOContext pos(long l);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVIOContext position(int i)
        {
            return (AVIOContext)super.position(i);
        }

        public native Read_packet_Pointer_BytePointer_int read_packet();

        public native AVIOContext read_packet(Read_packet_Pointer_BytePointer_int read_packet_pointer_bytepointer_int);

        public native Read_pause_Pointer_int read_pause();

        public native AVIOContext read_pause(Read_pause_Pointer_int read_pause_pointer_int);

        public native Read_seek_Pointer_int_long_int read_seek();

        public native AVIOContext read_seek(Read_seek_Pointer_int_long_int read_seek_pointer_int_long_int);

        public native Seek_Pointer_long_int seek();

        public native AVIOContext seek(Seek_Pointer_long_int seek_pointer_long_int);

        public native int seek_count();

        public native AVIOContext seek_count(int i);

        public native int seekable();

        public native AVIOContext seekable(int i);

        public native Update_checksum_long_BytePointer_int update_checksum();

        public native AVIOContext update_checksum(Update_checksum_long_BytePointer_int update_checksum_long_bytepointer_int);

        public native int write_flag();

        public native AVIOContext write_flag(int i);

        public native Write_packet_Pointer_BytePointer_int write_packet();

        public native AVIOContext write_packet(Write_packet_Pointer_BytePointer_int write_packet_pointer_bytepointer_int);

        public native int writeout_count();

        public native AVIOContext writeout_count(int i);

        static 
        {
            Loader.load();
        }

        public AVIOContext()
        {
            allocate();
        }

        public AVIOContext(int i)
        {
            allocateArray(i);
        }

        public AVIOContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVIOContext.Read_packet_Pointer_BytePointer_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer, BytePointer bytepointer, int i);

        static 
        {
            Loader.load();
        }

        protected AVIOContext.Read_packet_Pointer_BytePointer_int()
        {
            allocate();
        }

        public AVIOContext.Read_packet_Pointer_BytePointer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVIOContext.Read_pause_Pointer_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer, int i);

        static 
        {
            Loader.load();
        }

        protected AVIOContext.Read_pause_Pointer_int()
        {
            allocate();
        }

        public AVIOContext.Read_pause_Pointer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVIOContext.Read_seek_Pointer_int_long_int extends FunctionPointer
    {

        private native void allocate();

        public native long call(Pointer pointer, int i, long l, int j);

        static 
        {
            Loader.load();
        }

        protected AVIOContext.Read_seek_Pointer_int_long_int()
        {
            allocate();
        }

        public AVIOContext.Read_seek_Pointer_int_long_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVIOContext.Seek_Pointer_long_int extends FunctionPointer
    {

        private native void allocate();

        public native long call(Pointer pointer, long l, int i);

        static 
        {
            Loader.load();
        }

        protected AVIOContext.Seek_Pointer_long_int()
        {
            allocate();
        }

        public AVIOContext.Seek_Pointer_long_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVIOContext.Update_checksum_long_BytePointer_int extends FunctionPointer
    {

        private native void allocate();

        public native long call(long l, BytePointer bytepointer, int i);

        static 
        {
            Loader.load();
        }

        protected AVIOContext.Update_checksum_long_BytePointer_int()
        {
            allocate();
        }

        public AVIOContext.Update_checksum_long_BytePointer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVIOContext.Write_packet_Pointer_BytePointer_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer, BytePointer bytepointer, int i);

        static 
        {
            Loader.load();
        }

        protected AVIOContext.Write_packet_Pointer_BytePointer_int()
        {
            allocate();
        }

        public AVIOContext.Write_packet_Pointer_BytePointer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVIOInterruptCB extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native Callback_Pointer callback();

        public native AVIOInterruptCB callback(Callback_Pointer callback_pointer);

        public native Pointer opaque();

        public native AVIOInterruptCB opaque(Pointer pointer);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVIOInterruptCB position(int i)
        {
            return (AVIOInterruptCB)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public AVIOInterruptCB()
        {
            allocate();
        }

        public AVIOInterruptCB(int i)
        {
            allocateArray(i);
        }

        public AVIOInterruptCB(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVIOInterruptCB.Callback_Pointer extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer);

        static 
        {
            Loader.load();
        }

        protected AVIOInterruptCB.Callback_Pointer()
        {
            allocate();
        }

        public AVIOInterruptCB.Callback_Pointer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVIndexEntry extends Pointer
    {

        public static final int AVINDEX_KEYFRAME = 1;

        private native void allocate();

        private native void allocateArray(int i);

        public native int flags();

        public native AVIndexEntry flags(int i);

        public native int min_distance();

        public native AVIndexEntry min_distance(int i);

        public native long pos();

        public native AVIndexEntry pos(long l);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVIndexEntry position(int i)
        {
            return (AVIndexEntry)super.position(i);
        }

        public native int size();

        public native AVIndexEntry size(int i);

        public native long timestamp();

        public native AVIndexEntry timestamp(long l);

        static 
        {
            Loader.load();
        }

        public AVIndexEntry()
        {
            allocate();
        }

        public AVIndexEntry(int i)
        {
            allocateArray(i);
        }

        public AVIndexEntry(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVInputFormat extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native PointerPointer codec_tag();

        public native AVCodecTag codec_tag(int i);

        public native BytePointer extensions();

        public native int flags();

        public native AVInputFormat flags(int i);

        public native BytePointer long_name();

        public native BytePointer name();

        public native AVInputFormat next();

        public native AVInputFormat next(AVInputFormat avinputformat);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVInputFormat position(int i)
        {
            return (AVInputFormat)super.position(i);
        }

        public native avutil.AVClass priv_class();

        public native int priv_data_size();

        public native AVInputFormat priv_data_size(int i);

        public native int raw_codec_id();

        public native AVInputFormat raw_codec_id(int i);

        public native Read_close_AVFormatContext read_close();

        public native AVInputFormat read_close(Read_close_AVFormatContext read_close_avformatcontext);

        public native Read_header_AVFormatContext read_header();

        public native AVInputFormat read_header(Read_header_AVFormatContext read_header_avformatcontext);

        public native Read_packet_AVFormatContext_AVPacket read_packet();

        public native AVInputFormat read_packet(Read_packet_AVFormatContext_AVPacket read_packet_avformatcontext_avpacket);

        public native Read_pause_AVFormatContext read_pause();

        public native AVInputFormat read_pause(Read_pause_AVFormatContext read_pause_avformatcontext);

        public native Read_play_AVFormatContext read_play();

        public native AVInputFormat read_play(Read_play_AVFormatContext read_play_avformatcontext);

        public native Read_probe_AVProbeData read_probe();

        public native AVInputFormat read_probe(Read_probe_AVProbeData read_probe_avprobedata);

        public native Read_seek_AVFormatContext_int_long_int read_seek();

        public native AVInputFormat read_seek(Read_seek_AVFormatContext_int_long_int read_seek_avformatcontext_int_long_int);

        public native Read_seek2_AVFormatContext_int_long_long_long_int read_seek2();

        public native AVInputFormat read_seek2(Read_seek2_AVFormatContext_int_long_long_long_int read_seek2_avformatcontext_int_long_long_long_int);

        public native Read_timestamp_AVFormatContext_int_LongPointer_long read_timestamp();

        public native AVInputFormat read_timestamp(Read_timestamp_AVFormatContext_int_LongPointer_long read_timestamp_avformatcontext_int_longpointer_long);

        static 
        {
            Loader.load();
        }

        public AVInputFormat()
        {
            allocate();
        }

        public AVInputFormat(int i)
        {
            allocateArray(i);
        }

        public AVInputFormat(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVInputFormat.Read_close_AVFormatContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFormatContext avformatcontext);

        static 
        {
            Loader.load();
        }

        protected AVInputFormat.Read_close_AVFormatContext()
        {
            allocate();
        }

        public AVInputFormat.Read_close_AVFormatContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVInputFormat.Read_header_AVFormatContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFormatContext avformatcontext);

        static 
        {
            Loader.load();
        }

        protected AVInputFormat.Read_header_AVFormatContext()
        {
            allocate();
        }

        public AVInputFormat.Read_header_AVFormatContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVInputFormat.Read_packet_AVFormatContext_AVPacket extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFormatContext avformatcontext, avcodec.AVPacket avpacket);

        static 
        {
            Loader.load();
        }

        protected AVInputFormat.Read_packet_AVFormatContext_AVPacket()
        {
            allocate();
        }

        public AVInputFormat.Read_packet_AVFormatContext_AVPacket(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVInputFormat.Read_pause_AVFormatContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFormatContext avformatcontext);

        static 
        {
            Loader.load();
        }

        protected AVInputFormat.Read_pause_AVFormatContext()
        {
            allocate();
        }

        public AVInputFormat.Read_pause_AVFormatContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVInputFormat.Read_play_AVFormatContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFormatContext avformatcontext);

        static 
        {
            Loader.load();
        }

        protected AVInputFormat.Read_play_AVFormatContext()
        {
            allocate();
        }

        public AVInputFormat.Read_play_AVFormatContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVInputFormat.Read_probe_AVProbeData extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVProbeData avprobedata);

        static 
        {
            Loader.load();
        }

        protected AVInputFormat.Read_probe_AVProbeData()
        {
            allocate();
        }

        public AVInputFormat.Read_probe_AVProbeData(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVInputFormat.Read_seek2_AVFormatContext_int_long_long_long_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFormatContext avformatcontext, int i, long l, long l1, long l2, int j);

        static 
        {
            Loader.load();
        }

        protected AVInputFormat.Read_seek2_AVFormatContext_int_long_long_long_int()
        {
            allocate();
        }

        public AVInputFormat.Read_seek2_AVFormatContext_int_long_long_long_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVInputFormat.Read_seek_AVFormatContext_int_long_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFormatContext avformatcontext, int i, long l, int j);

        static 
        {
            Loader.load();
        }

        protected AVInputFormat.Read_seek_AVFormatContext_int_long_int()
        {
            allocate();
        }

        public AVInputFormat.Read_seek_AVFormatContext_int_long_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVInputFormat.Read_timestamp_AVFormatContext_int_LongPointer_long extends FunctionPointer
    {

        private native void allocate();

        public native long call(AVFormatContext avformatcontext, int i, LongPointer longpointer, long l);

        static 
        {
            Loader.load();
        }

        protected AVInputFormat.Read_timestamp_AVFormatContext_int_LongPointer_long()
        {
            allocate();
        }

        public AVInputFormat.Read_timestamp_AVFormatContext_int_LongPointer_long(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVOutputFormat extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int audio_codec();

        public native AVOutputFormat audio_codec(int i);

        public native PointerPointer codec_tag();

        public native AVCodecTag codec_tag(int i);

        public native BytePointer extensions();

        public native int flags();

        public native AVOutputFormat flags(int i);

        public native Get_output_timestamp_AVFormatContext_int_LongPointer_LongPointer get_output_timestamp();

        public native AVOutputFormat get_output_timestamp(Get_output_timestamp_AVFormatContext_int_LongPointer_LongPointer get_output_timestamp_avformatcontext_int_longpointer_longpointer);

        public native Interleave_packet_AVFormatContext_AVPacket_AVPacket_int interleave_packet();

        public native AVOutputFormat interleave_packet(Interleave_packet_AVFormatContext_AVPacket_AVPacket_int interleave_packet_avformatcontext_avpacket_avpacket_int);

        public native BytePointer long_name();

        public native BytePointer mime_type();

        public native BytePointer name();

        public native AVOutputFormat next();

        public native AVOutputFormat next(AVOutputFormat avoutputformat);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVOutputFormat position(int i)
        {
            return (AVOutputFormat)super.position(i);
        }

        public native avutil.AVClass priv_class();

        public native int priv_data_size();

        public native AVOutputFormat priv_data_size(int i);

        public native Query_codec_int_int query_codec();

        public native AVOutputFormat query_codec(Query_codec_int_int query_codec_int_int);

        public native int subtitle_codec();

        public native AVOutputFormat subtitle_codec(int i);

        public native int video_codec();

        public native AVOutputFormat video_codec(int i);

        public native Write_header_AVFormatContext write_header();

        public native AVOutputFormat write_header(Write_header_AVFormatContext write_header_avformatcontext);

        public native Write_packet_AVFormatContext_AVPacket write_packet();

        public native AVOutputFormat write_packet(Write_packet_AVFormatContext_AVPacket write_packet_avformatcontext_avpacket);

        public native Write_trailer_AVFormatContext write_trailer();

        public native AVOutputFormat write_trailer(Write_trailer_AVFormatContext write_trailer_avformatcontext);

        static 
        {
            Loader.load();
        }

        public AVOutputFormat()
        {
            allocate();
        }

        public AVOutputFormat(int i)
        {
            allocateArray(i);
        }

        public AVOutputFormat(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVOutputFormat.Get_output_timestamp_AVFormatContext_int_LongPointer_LongPointer extends FunctionPointer
    {

        private native void allocate();

        public native void call(AVFormatContext avformatcontext, int i, LongPointer longpointer, LongPointer longpointer1);

        static 
        {
            Loader.load();
        }

        protected AVOutputFormat.Get_output_timestamp_AVFormatContext_int_LongPointer_LongPointer()
        {
            allocate();
        }

        public AVOutputFormat.Get_output_timestamp_AVFormatContext_int_LongPointer_LongPointer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVOutputFormat.Interleave_packet_AVFormatContext_AVPacket_AVPacket_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFormatContext avformatcontext, avcodec.AVPacket avpacket, avcodec.AVPacket avpacket1, int i);

        static 
        {
            Loader.load();
        }

        protected AVOutputFormat.Interleave_packet_AVFormatContext_AVPacket_AVPacket_int()
        {
            allocate();
        }

        public AVOutputFormat.Interleave_packet_AVFormatContext_AVPacket_AVPacket_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVOutputFormat.Query_codec_int_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(int i, int j);

        static 
        {
            Loader.load();
        }

        protected AVOutputFormat.Query_codec_int_int()
        {
            allocate();
        }

        public AVOutputFormat.Query_codec_int_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVOutputFormat.Write_header_AVFormatContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFormatContext avformatcontext);

        static 
        {
            Loader.load();
        }

        protected AVOutputFormat.Write_header_AVFormatContext()
        {
            allocate();
        }

        public AVOutputFormat.Write_header_AVFormatContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVOutputFormat.Write_packet_AVFormatContext_AVPacket extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFormatContext avformatcontext, avcodec.AVPacket avpacket);

        static 
        {
            Loader.load();
        }

        protected AVOutputFormat.Write_packet_AVFormatContext_AVPacket()
        {
            allocate();
        }

        public AVOutputFormat.Write_packet_AVFormatContext_AVPacket(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVOutputFormat.Write_trailer_AVFormatContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFormatContext avformatcontext);

        static 
        {
            Loader.load();
        }

        protected AVOutputFormat.Write_trailer_AVFormatContext()
        {
            allocate();
        }

        public AVOutputFormat.Write_trailer_AVFormatContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVPacketList extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native AVPacketList next();

        public native AVPacketList next(AVPacketList avpacketlist);

        public native avcodec.AVPacket pkt();

        public native AVPacketList pkt(avcodec.AVPacket avpacket);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVPacketList position(int i)
        {
            return (AVPacketList)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public AVPacketList()
        {
            allocate();
        }

        public AVPacketList(int i)
        {
            allocateArray(i);
        }

        public AVPacketList(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVProbeData extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native BytePointer buf();

        public native AVProbeData buf(BytePointer bytepointer);

        public native int buf_size();

        public native AVProbeData buf_size(int i);

        public native BytePointer filename();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVProbeData position(int i)
        {
            return (AVProbeData)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public AVProbeData()
        {
            allocate();
        }

        public AVProbeData(int i)
        {
            allocateArray(i);
        }

        public AVProbeData(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVProgram extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int discard();

        public native AVProgram discard(int i);

        public native long end_time();

        public native AVProgram end_time(long l);

        public native int flags();

        public native AVProgram flags(int i);

        public native int id();

        public native AVProgram id(int i);

        public native AVProgram metadata(avutil.AVDictionary avdictionary);

        public native avutil.AVDictionary metadata();

        public native int nb_stream_indexes();

        public native AVProgram nb_stream_indexes(int i);

        public native int pcr_pid();

        public native AVProgram pcr_pid(int i);

        public native int pmt_pid();

        public native AVProgram pmt_pid(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVProgram position(int i)
        {
            return (AVProgram)super.position(i);
        }

        public native int program_num();

        public native AVProgram program_num(int i);

        public native int pts_wrap_behavior();

        public native AVProgram pts_wrap_behavior(int i);

        public native long pts_wrap_reference();

        public native AVProgram pts_wrap_reference(long l);

        public native long start_time();

        public native AVProgram start_time(long l);

        public native IntPointer stream_index();

        public native AVProgram stream_index(IntPointer intpointer);

        static 
        {
            Loader.load();
        }

        public AVProgram()
        {
            allocate();
        }

        public AVProgram(int i)
        {
            allocateArray(i);
        }

        public AVProgram(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVStream extends Pointer
    {

        public static final int MAX_PROBE_PACKETS = 2500;
        public static final int MAX_REORDER_DELAY = 16;
        public static final int MAX_STD_TIMEBASES = 726;

        private native void allocate();

        private native void allocateArray(int i);

        public native avcodec.AVPacket attached_pic();

        public native AVStream attached_pic(avcodec.AVPacket avpacket);

        public native AVStream avg_frame_rate(avutil.AVRational avrational);

        public native avutil.AVRational avg_frame_rate();

        public native avcodec.AVCodecContext codec();

        public native AVStream codec(avcodec.AVCodecContext avcodeccontext);

        public native int codec_info_nb_frames();

        public native AVStream codec_info_nb_frames(int i);

        public native long cur_dts();

        public native AVStream cur_dts(long l);

        public native int discard();

        public native AVStream discard(int i);

        public native int disposition();

        public native AVStream disposition(int i);

        public native long duration();

        public native AVStream duration(long l);

        public native long first_dts();

        public native AVStream first_dts(long l);

        public native int id();

        public native AVStream id(int i);

        public native int index();

        public native AVStream index(int i);

        public native AVIndexEntry index_entries();

        public native AVStream index_entries(AVIndexEntry avindexentry);

        public native int index_entries_allocated_size();

        public native AVStream index_entries_allocated_size(int i);

        public native long interleaver_chunk_duration();

        public native AVStream interleaver_chunk_duration(long l);

        public native long interleaver_chunk_size();

        public native AVStream interleaver_chunk_size(long l);

        public native int last_IP_duration();

        public native AVStream last_IP_duration(int i);

        public native long last_IP_pts();

        public native AVStream last_IP_pts(long l);

        public native AVPacketList last_in_packet_buffer();

        public native AVStream last_in_packet_buffer(AVPacketList avpacketlist);

        public native AVStream metadata(avutil.AVDictionary avdictionary);

        public native avutil.AVDictionary metadata();

        public native long mux_ts_offset();

        public native AVStream mux_ts_offset(long l);

        public native int nb_decoded_frames();

        public native AVStream nb_decoded_frames(int i);

        public native long nb_frames();

        public native AVStream nb_frames(long l);

        public native int nb_index_entries();

        public native AVStream nb_index_entries(int i);

        public native int need_parsing();

        public native AVStream need_parsing(int i);

        public native avcodec.AVCodecParserContext parser();

        public native AVStream parser(avcodec.AVCodecParserContext avcodecparsercontext);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVStream position(int i)
        {
            return (AVStream)super.position(i);
        }

        public native Pointer priv_data();

        public native AVStream priv_data(Pointer pointer);

        public native AVProbeData probe_data();

        public native AVStream probe_data(AVProbeData avprobedata);

        public native int probe_packets();

        public native AVStream probe_packets(int i);

        public native AVFrac pts();

        public native AVStream pts(AVFrac avfrac);

        public native long pts_buffer(int i);

        public native LongPointer pts_buffer();

        public native AVStream pts_buffer(int i, long l);

        public native int pts_wrap_behavior();

        public native AVStream pts_wrap_behavior(int i);

        public native int pts_wrap_bits();

        public native AVStream pts_wrap_bits(int i);

        public native long pts_wrap_reference();

        public native AVStream pts_wrap_reference(long l);

        public native AVStream r_frame_rate(avutil.AVRational avrational);

        public native avutil.AVRational r_frame_rate();

        public native long reference_dts();

        public native AVStream reference_dts(long l);

        public native int request_probe();

        public native AVStream request_probe(int i);

        public native AVStream sample_aspect_ratio(avutil.AVRational avrational);

        public native avutil.AVRational sample_aspect_ratio();

        public native int skip_samples();

        public native AVStream skip_samples(int i);

        public native int skip_to_keyframe();

        public native AVStream skip_to_keyframe(int i);

        public native long start_time();

        public native AVStream start_time(long l);

        public native int stream_identifier();

        public native AVStream stream_identifier(int i);

        public native AVStream time_base(avutil.AVRational avrational);

        public native avutil.AVRational time_base();

        static 
        {
            Loader.load();
        }

        public AVStream()
        {
            allocate();
        }

        public AVStream(int i)
        {
            allocateArray(i);
        }

        public AVStream(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Read_packet_Pointer_ByteBuffer_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer, ByteBuffer bytebuffer, int i);

        static 
        {
            Loader.load();
        }

        protected Read_packet_Pointer_ByteBuffer_int()
        {
            allocate();
        }

        public Read_packet_Pointer_ByteBuffer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Read_packet_Pointer_BytePointer_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer, BytePointer bytepointer, int i);

        static 
        {
            Loader.load();
        }

        protected Read_packet_Pointer_BytePointer_int()
        {
            allocate();
        }

        public Read_packet_Pointer_BytePointer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Read_packet_Pointer_byte_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer, byte abyte0[], int i);

        static 
        {
            Loader.load();
        }

        protected Read_packet_Pointer_byte_int()
        {
            allocate();
        }

        public Read_packet_Pointer_byte_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Seek_Pointer_long_int extends FunctionPointer
    {

        private native void allocate();

        public native long call(Pointer pointer, long l, int i);

        static 
        {
            Loader.load();
        }

        protected Seek_Pointer_long_int()
        {
            allocate();
        }

        public Seek_Pointer_long_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Write_packet_Pointer_ByteBuffer_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer, ByteBuffer bytebuffer, int i);

        static 
        {
            Loader.load();
        }

        protected Write_packet_Pointer_ByteBuffer_int()
        {
            allocate();
        }

        public Write_packet_Pointer_ByteBuffer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Write_packet_Pointer_BytePointer_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer, BytePointer bytepointer, int i);

        static 
        {
            Loader.load();
        }

        protected Write_packet_Pointer_BytePointer_int()
        {
            allocate();
        }

        public Write_packet_Pointer_BytePointer_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class Write_packet_Pointer_byte_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(Pointer pointer, byte abyte0[], int i);

        static 
        {
            Loader.load();
        }

        protected Write_packet_Pointer_byte_int()
        {
            allocate();
        }

        public Write_packet_Pointer_byte_int(Pointer pointer)
        {
            super(pointer);
        }
    }


    public static final int AVFMTCTX_NOHEADER = 1;
    public static final int AVFMT_ALLOW_FLUSH = 0x10000;
    public static final int AVFMT_DURATION_FROM_BITRATE = 2;
    public static final int AVFMT_DURATION_FROM_PTS = 0;
    public static final int AVFMT_DURATION_FROM_STREAM = 1;
    public static final int AVFMT_GENERIC_INDEX = 256;
    public static final int AVFMT_GLOBALHEADER = 64;
    public static final int AVFMT_NEEDNUMBER = 2;
    public static final int AVFMT_NOBINSEARCH = 8192;
    public static final int AVFMT_NODIMENSIONS = 2048;
    public static final int AVFMT_NOFILE = 1;
    public static final int AVFMT_NOGENSEARCH = 16384;
    public static final int AVFMT_NOSTREAMS = 4096;
    public static final int AVFMT_NOTIMESTAMPS = 128;
    public static final int AVFMT_NO_BYTE_SEEK = 32768;
    public static final int AVFMT_RAWPICTURE = 32;
    public static final int AVFMT_SEEK_TO_PTS = 0x4000000;
    public static final int AVFMT_SHOW_IDS = 8;
    public static final int AVFMT_TS_DISCONT = 512;
    public static final int AVFMT_TS_NEGATIVE = 0x40000;
    public static final int AVFMT_TS_NONSTRICT = 0x20000;
    public static final int AVFMT_VARIABLE_FPS = 1024;
    public static final int AVIO_FLAG_DIRECT = 32768;
    public static final int AVIO_FLAG_NONBLOCK = 8;
    public static final int AVIO_FLAG_READ = 1;
    public static final int AVIO_FLAG_READ_WRITE = 3;
    public static final int AVIO_FLAG_WRITE = 2;
    public static final int AVIO_SEEKABLE_NORMAL = 1;
    public static final int AVPROBE_PADDING_SIZE = 32;
    public static final int AVPROBE_SCORE_EXTENSION = 50;
    public static final int AVPROBE_SCORE_MAX = 100;
    public static final int AVPROBE_SCORE_RETRY = AVPROBE_SCORE_RETRY();
    public static final int AVSEEK_FLAG_ANY = 4;
    public static final int AVSEEK_FLAG_BACKWARD = 1;
    public static final int AVSEEK_FLAG_BYTE = 2;
    public static final int AVSEEK_FLAG_FRAME = 8;
    public static final int AVSEEK_FORCE = 0x20000;
    public static final int AVSEEK_SIZE = 0x10000;
    public static final int AVSTREAM_PARSE_FULL = 1;
    public static final int AVSTREAM_PARSE_FULL_ONCE = 4;
    public static final int AVSTREAM_PARSE_FULL_RAW = AVSTREAM_PARSE_FULL_RAW();
    public static final int AVSTREAM_PARSE_HEADERS = 2;
    public static final int AVSTREAM_PARSE_NONE = 0;
    public static final int AVSTREAM_PARSE_TIMESTAMPS = 3;
    public static final int AV_DISPOSITION_ATTACHED_PIC = 1024;
    public static final int AV_DISPOSITION_CAPTIONS = 0x10000;
    public static final int AV_DISPOSITION_CLEAN_EFFECTS = 512;
    public static final int AV_DISPOSITION_COMMENT = 8;
    public static final int AV_DISPOSITION_DEFAULT = 1;
    public static final int AV_DISPOSITION_DESCRIPTIONS = 0x20000;
    public static final int AV_DISPOSITION_DUB = 2;
    public static final int AV_DISPOSITION_FORCED = 64;
    public static final int AV_DISPOSITION_HEARING_IMPAIRED = 128;
    public static final int AV_DISPOSITION_KARAOKE = 32;
    public static final int AV_DISPOSITION_LYRICS = 16;
    public static final int AV_DISPOSITION_METADATA = 0x40000;
    public static final int AV_DISPOSITION_ORIGINAL = 4;
    public static final int AV_DISPOSITION_VISUAL_IMPAIRED = 256;
    public static final int AV_PROGRAM_RUNNING = 1;
    public static final int AV_PTS_WRAP_ADD_OFFSET = 1;
    public static final int AV_PTS_WRAP_IGNORE = 0;
    public static final int AV_PTS_WRAP_SUB_OFFSET = -1;

    public avformat()
    {
    }

    public static native int AVPROBE_SCORE_RETRY();

    public static native int AVSTREAM_PARSE_FULL_RAW();

    public static native int av_add_index_entry(AVStream avstream, long l, long l1, int i, int j, int k);

    public static native int av_append_packet(AVIOContext aviocontext, avcodec.AVPacket avpacket, int i);

    public static native void av_close_input_file(AVFormatContext avformatcontext);

    public static native int av_codec_get_id(PointerPointer pointerpointer, int i);

    public static native int av_codec_get_id(AVCodecTag avcodectag, int i);

    public static native int av_codec_get_tag(PointerPointer pointerpointer, int i);

    public static native int av_codec_get_tag(AVCodecTag avcodectag, int i);

    public static native int av_codec_get_tag2(PointerPointer pointerpointer, int i, IntPointer intpointer);

    public static native int av_codec_get_tag2(AVCodecTag avcodectag, int i, IntPointer intpointer);

    public static native int av_codec_get_tag2(AVCodecTag avcodectag, int i, IntBuffer intbuffer);

    public static native int av_codec_get_tag2(AVCodecTag avcodectag, int i, int ai[]);

    public static native int av_demuxer_open(AVFormatContext avformatcontext);

    public static native void av_dump_format(AVFormatContext avformatcontext, int i, BytePointer bytepointer, int j);

    public static native void av_dump_format(AVFormatContext avformatcontext, int i, String s, int j);

    public static native int av_filename_number_test(BytePointer bytepointer);

    public static native int av_filename_number_test(String s);

    public static native int av_find_best_stream(AVFormatContext avformatcontext, int i, int j, int k, PointerPointer pointerpointer, int l);

    public static native int av_find_best_stream(AVFormatContext avformatcontext, int i, int j, int k, avcodec.AVCodec avcodec, int l);

    public static native int av_find_default_stream_index(AVFormatContext avformatcontext);

    public static native AVInputFormat av_find_input_format(BytePointer bytepointer);

    public static native AVInputFormat av_find_input_format(String s);

    public static native AVProgram av_find_program_from_stream(AVFormatContext avformatcontext, AVProgram avprogram, int i);

    public static native int av_find_stream_info(AVFormatContext avformatcontext);

    public static native int av_fmt_ctx_get_duration_estimation_method(AVFormatContext avformatcontext);

    public static native int av_get_frame_filename(BytePointer bytepointer, int i, BytePointer bytepointer1, int j);

    public static native int av_get_frame_filename(BytePointer bytepointer, int i, String s, int j);

    public static native int av_get_frame_filename(ByteBuffer bytebuffer, int i, BytePointer bytepointer, int j);

    public static native int av_get_frame_filename(ByteBuffer bytebuffer, int i, String s, int j);

    public static native int av_get_frame_filename(byte abyte0[], int i, BytePointer bytepointer, int j);

    public static native int av_get_frame_filename(byte abyte0[], int i, String s, int j);

    public static native int av_get_output_timestamp(AVFormatContext avformatcontext, int i, LongPointer longpointer, LongPointer longpointer1);

    public static native int av_get_output_timestamp(AVFormatContext avformatcontext, int i, LongBuffer longbuffer, LongBuffer longbuffer1);

    public static native int av_get_output_timestamp(AVFormatContext avformatcontext, int i, long al[], long al1[]);

    public static native int av_get_packet(AVIOContext aviocontext, avcodec.AVPacket avpacket, int i);

    public static native int av_guess_codec(AVOutputFormat avoutputformat, BytePointer bytepointer, BytePointer bytepointer1, BytePointer bytepointer2, int i);

    public static native int av_guess_codec(AVOutputFormat avoutputformat, String s, String s1, String s2, int i);

    public static native AVOutputFormat av_guess_format(BytePointer bytepointer, BytePointer bytepointer1, BytePointer bytepointer2);

    public static native AVOutputFormat av_guess_format(String s, String s1, String s2);

    public static native avutil.AVRational av_guess_frame_rate(AVFormatContext avformatcontext, AVStream avstream, avutil.AVFrame avframe);

    public static native avutil.AVRational av_guess_sample_aspect_ratio(AVFormatContext avformatcontext, AVStream avstream, avutil.AVFrame avframe);

    public static native void av_hex_dump(Pointer pointer, BytePointer bytepointer, int i);

    public static native void av_hex_dump(Pointer pointer, ByteBuffer bytebuffer, int i);

    public static native void av_hex_dump(Pointer pointer, byte abyte0[], int i);

    public static native void av_hex_dump_log(Pointer pointer, int i, BytePointer bytepointer, int j);

    public static native void av_hex_dump_log(Pointer pointer, int i, ByteBuffer bytebuffer, int j);

    public static native void av_hex_dump_log(Pointer pointer, int i, byte abyte0[], int j);

    public static native AVInputFormat av_iformat_next(AVInputFormat avinputformat);

    public static native int av_index_search_timestamp(AVStream avstream, long l, int i);

    public static native int av_interleaved_write_frame(AVFormatContext avformatcontext, avcodec.AVPacket avpacket);

    public static native int av_match_ext(BytePointer bytepointer, BytePointer bytepointer1);

    public static native int av_match_ext(String s, String s1);

    public static native AVProgram av_new_program(AVFormatContext avformatcontext, int i);

    public static native AVStream av_new_stream(AVFormatContext avformatcontext, int i);

    public static native AVOutputFormat av_oformat_next(AVOutputFormat avoutputformat);

    public static native void av_pkt_dump2(Pointer pointer, avcodec.AVPacket avpacket, int i, AVStream avstream);

    public static native void av_pkt_dump_log2(Pointer pointer, int i, avcodec.AVPacket avpacket, int j, AVStream avstream);

    public static native int av_probe_input_buffer(AVIOContext aviocontext, PointerPointer pointerpointer, BytePointer bytepointer, Pointer pointer, int i, int j);

    public static native int av_probe_input_buffer(AVIOContext aviocontext, AVInputFormat avinputformat, BytePointer bytepointer, Pointer pointer, int i, int j);

    public static native int av_probe_input_buffer(AVIOContext aviocontext, AVInputFormat avinputformat, String s, Pointer pointer, int i, int j);

    public static native AVInputFormat av_probe_input_format(AVProbeData avprobedata, int i);

    public static native AVInputFormat av_probe_input_format2(AVProbeData avprobedata, int i, IntPointer intpointer);

    public static native AVInputFormat av_probe_input_format2(AVProbeData avprobedata, int i, IntBuffer intbuffer);

    public static native AVInputFormat av_probe_input_format2(AVProbeData avprobedata, int i, int ai[]);

    public static native AVInputFormat av_probe_input_format3(AVProbeData avprobedata, int i, IntPointer intpointer);

    public static native AVInputFormat av_probe_input_format3(AVProbeData avprobedata, int i, IntBuffer intbuffer);

    public static native AVInputFormat av_probe_input_format3(AVProbeData avprobedata, int i, int ai[]);

    public static native int av_read_frame(AVFormatContext avformatcontext, avcodec.AVPacket avpacket);

    public static native int av_read_packet(AVFormatContext avformatcontext, avcodec.AVPacket avpacket);

    public static native int av_read_pause(AVFormatContext avformatcontext);

    public static native int av_read_play(AVFormatContext avformatcontext);

    public static native void av_register_all();

    public static native void av_register_input_format(AVInputFormat avinputformat);

    public static native void av_register_output_format(AVOutputFormat avoutputformat);

    public static native int av_sdp_create(PointerPointer pointerpointer, int i, BytePointer bytepointer, int j);

    public static native int av_sdp_create(AVFormatContext avformatcontext, int i, BytePointer bytepointer, int j);

    public static native int av_sdp_create(AVFormatContext avformatcontext, int i, ByteBuffer bytebuffer, int j);

    public static native int av_sdp_create(AVFormatContext avformatcontext, int i, byte abyte0[], int j);

    public static native int av_seek_frame(AVFormatContext avformatcontext, int i, long l, int j);

    public static native void av_set_pts_info(AVStream avstream, int i, int j, int k);

    public static native avutil.AVRational av_stream_get_r_frame_rate(AVStream avstream);

    public static native void av_stream_set_r_frame_rate(AVStream avstream, avutil.AVRational avrational);

    public static native void av_url_split(BytePointer bytepointer, int i, BytePointer bytepointer1, int j, BytePointer bytepointer2, int k, IntPointer intpointer, BytePointer bytepointer3, 
            int l, BytePointer bytepointer4);

    public static native void av_url_split(BytePointer bytepointer, int i, BytePointer bytepointer1, int j, BytePointer bytepointer2, int k, IntPointer intpointer, BytePointer bytepointer3, 
            int l, String s);

    public static native void av_url_split(ByteBuffer bytebuffer, int i, ByteBuffer bytebuffer1, int j, ByteBuffer bytebuffer2, int k, IntBuffer intbuffer, ByteBuffer bytebuffer3, 
            int l, BytePointer bytepointer);

    public static native void av_url_split(ByteBuffer bytebuffer, int i, ByteBuffer bytebuffer1, int j, ByteBuffer bytebuffer2, int k, IntBuffer intbuffer, ByteBuffer bytebuffer3, 
            int l, String s);

    public static native void av_url_split(byte abyte0[], int i, byte abyte1[], int j, byte abyte2[], int k, int ai[], byte abyte3[], 
            int l, BytePointer bytepointer);

    public static native void av_url_split(byte abyte0[], int i, byte abyte1[], int j, byte abyte2[], int k, int ai[], byte abyte3[], 
            int l, String s);

    public static native int av_write_frame(AVFormatContext avformatcontext, avcodec.AVPacket avpacket);

    public static native int av_write_trailer(AVFormatContext avformatcontext);

    public static native AVFormatContext avformat_alloc_context();

    public static native AVFormatContext avformat_alloc_output_context(BytePointer bytepointer, AVOutputFormat avoutputformat, BytePointer bytepointer1);

    public static native AVFormatContext avformat_alloc_output_context(String s, AVOutputFormat avoutputformat, String s1);

    public static native int avformat_alloc_output_context2(PointerPointer pointerpointer, AVOutputFormat avoutputformat, BytePointer bytepointer, BytePointer bytepointer1);

    public static native int avformat_alloc_output_context2(AVFormatContext avformatcontext, AVOutputFormat avoutputformat, BytePointer bytepointer, BytePointer bytepointer1);

    public static native int avformat_alloc_output_context2(AVFormatContext avformatcontext, AVOutputFormat avoutputformat, String s, String s1);

    public static native void avformat_close_input(PointerPointer pointerpointer);

    public static native void avformat_close_input(AVFormatContext avformatcontext);

    public static native BytePointer avformat_configuration();

    public static native int avformat_find_stream_info(AVFormatContext avformatcontext, PointerPointer pointerpointer);

    public static native int avformat_find_stream_info(AVFormatContext avformatcontext, avutil.AVDictionary avdictionary);

    public static native void avformat_free_context(AVFormatContext avformatcontext);

    public static native avutil.AVClass avformat_get_class();

    public static native AVCodecTag avformat_get_riff_audio_tags();

    public static native AVCodecTag avformat_get_riff_video_tags();

    public static native BytePointer avformat_license();

    public static native int avformat_match_stream_specifier(AVFormatContext avformatcontext, AVStream avstream, BytePointer bytepointer);

    public static native int avformat_match_stream_specifier(AVFormatContext avformatcontext, AVStream avstream, String s);

    public static native int avformat_network_deinit();

    public static native int avformat_network_init();

    public static native AVStream avformat_new_stream(AVFormatContext avformatcontext, avcodec.AVCodec avcodec);

    public static native int avformat_open_input(PointerPointer pointerpointer, BytePointer bytepointer, AVInputFormat avinputformat, PointerPointer pointerpointer1);

    public static native int avformat_open_input(AVFormatContext avformatcontext, BytePointer bytepointer, AVInputFormat avinputformat, avutil.AVDictionary avdictionary);

    public static native int avformat_open_input(AVFormatContext avformatcontext, String s, AVInputFormat avinputformat, avutil.AVDictionary avdictionary);

    public static native int avformat_query_codec(AVOutputFormat avoutputformat, int i, int j);

    public static native int avformat_queue_attached_pictures(AVFormatContext avformatcontext);

    public static native int avformat_seek_file(AVFormatContext avformatcontext, int i, long l, long l1, long l2, 
            int j);

    public static native int avformat_version();

    public static native int avformat_write_header(AVFormatContext avformatcontext, PointerPointer pointerpointer);

    public static native int avformat_write_header(AVFormatContext avformatcontext, avutil.AVDictionary avdictionary);

    public static native AVIOContext avio_alloc_context(BytePointer bytepointer, int i, int j, Pointer pointer, Read_packet_Pointer_BytePointer_int read_packet_pointer_bytepointer_int, Write_packet_Pointer_BytePointer_int write_packet_pointer_bytepointer_int, Seek_Pointer_long_int seek_pointer_long_int);

    public static native AVIOContext avio_alloc_context(ByteBuffer bytebuffer, int i, int j, Pointer pointer, Read_packet_Pointer_ByteBuffer_int read_packet_pointer_bytebuffer_int, Write_packet_Pointer_ByteBuffer_int write_packet_pointer_bytebuffer_int, Seek_Pointer_long_int seek_pointer_long_int);

    public static native AVIOContext avio_alloc_context(byte abyte0[], int i, int j, Pointer pointer, Read_packet_Pointer_byte_int read_packet_pointer_byte_int, Write_packet_Pointer_byte_int write_packet_pointer_byte_int, Seek_Pointer_long_int seek_pointer_long_int);

    public static native int avio_check(BytePointer bytepointer, int i);

    public static native int avio_check(String s, int i);

    public static native int avio_close(AVIOContext aviocontext);

    public static native int avio_close_dyn_buf(AVIOContext aviocontext, BytePointer bytepointer);

    public static native int avio_close_dyn_buf(AVIOContext aviocontext, PointerPointer pointerpointer);

    public static native int avio_close_dyn_buf(AVIOContext aviocontext, ByteBuffer bytebuffer);

    public static native int avio_close_dyn_buf(AVIOContext aviocontext, byte abyte0[]);

    public static native int avio_closep(PointerPointer pointerpointer);

    public static native int avio_closep(AVIOContext aviocontext);

    public static native BytePointer avio_enum_protocols(Pointer pointer, int i);

    public static native BytePointer avio_enum_protocols(PointerPointer pointerpointer, int i);

    public static native void avio_flush(AVIOContext aviocontext);

    public static native int avio_get_str(AVIOContext aviocontext, int i, BytePointer bytepointer, int j);

    public static native int avio_get_str(AVIOContext aviocontext, int i, ByteBuffer bytebuffer, int j);

    public static native int avio_get_str(AVIOContext aviocontext, int i, byte abyte0[], int j);

    public static native int avio_get_str16be(AVIOContext aviocontext, int i, BytePointer bytepointer, int j);

    public static native int avio_get_str16be(AVIOContext aviocontext, int i, ByteBuffer bytebuffer, int j);

    public static native int avio_get_str16be(AVIOContext aviocontext, int i, byte abyte0[], int j);

    public static native int avio_get_str16le(AVIOContext aviocontext, int i, BytePointer bytepointer, int j);

    public static native int avio_get_str16le(AVIOContext aviocontext, int i, ByteBuffer bytebuffer, int j);

    public static native int avio_get_str16le(AVIOContext aviocontext, int i, byte abyte0[], int j);

    public static native int avio_open(PointerPointer pointerpointer, BytePointer bytepointer, int i);

    public static native int avio_open(AVIOContext aviocontext, BytePointer bytepointer, int i);

    public static native int avio_open(AVIOContext aviocontext, String s, int i);

    public static native int avio_open2(PointerPointer pointerpointer, BytePointer bytepointer, int i, AVIOInterruptCB aviointerruptcb, PointerPointer pointerpointer1);

    public static native int avio_open2(AVIOContext aviocontext, BytePointer bytepointer, int i, AVIOInterruptCB aviointerruptcb, avutil.AVDictionary avdictionary);

    public static native int avio_open2(AVIOContext aviocontext, String s, int i, AVIOInterruptCB aviointerruptcb, avutil.AVDictionary avdictionary);

    public static native int avio_open_dyn_buf(PointerPointer pointerpointer);

    public static native int avio_open_dyn_buf(AVIOContext aviocontext);

    public static native int avio_pause(AVIOContext aviocontext, int i);

    public static native int avio_printf(AVIOContext aviocontext, BytePointer bytepointer);

    public static native int avio_printf(AVIOContext aviocontext, String s);

    public static native int avio_put_str(AVIOContext aviocontext, BytePointer bytepointer);

    public static native int avio_put_str(AVIOContext aviocontext, String s);

    public static native int avio_put_str16le(AVIOContext aviocontext, BytePointer bytepointer);

    public static native int avio_put_str16le(AVIOContext aviocontext, String s);

    public static native int avio_r8(AVIOContext aviocontext);

    public static native int avio_rb16(AVIOContext aviocontext);

    public static native int avio_rb24(AVIOContext aviocontext);

    public static native int avio_rb32(AVIOContext aviocontext);

    public static native long avio_rb64(AVIOContext aviocontext);

    public static native int avio_read(AVIOContext aviocontext, BytePointer bytepointer, int i);

    public static native int avio_read(AVIOContext aviocontext, ByteBuffer bytebuffer, int i);

    public static native int avio_read(AVIOContext aviocontext, byte abyte0[], int i);

    public static native int avio_rl16(AVIOContext aviocontext);

    public static native int avio_rl24(AVIOContext aviocontext);

    public static native int avio_rl32(AVIOContext aviocontext);

    public static native long avio_rl64(AVIOContext aviocontext);

    public static native long avio_seek(AVIOContext aviocontext, long l, int i);

    public static native long avio_seek_time(AVIOContext aviocontext, int i, long l, int j);

    public static native long avio_size(AVIOContext aviocontext);

    public static native long avio_skip(AVIOContext aviocontext, long l);

    public static native long avio_tell(AVIOContext aviocontext);

    public static native void avio_w8(AVIOContext aviocontext, int i);

    public static native void avio_wb16(AVIOContext aviocontext, int i);

    public static native void avio_wb24(AVIOContext aviocontext, int i);

    public static native void avio_wb32(AVIOContext aviocontext, int i);

    public static native void avio_wb64(AVIOContext aviocontext, long l);

    public static native void avio_wl16(AVIOContext aviocontext, int i);

    public static native void avio_wl24(AVIOContext aviocontext, int i);

    public static native void avio_wl32(AVIOContext aviocontext, int i);

    public static native void avio_wl64(AVIOContext aviocontext, long l);

    public static native void avio_write(AVIOContext aviocontext, BytePointer bytepointer, int i);

    public static native void avio_write(AVIOContext aviocontext, ByteBuffer bytebuffer, int i);

    public static native void avio_write(AVIOContext aviocontext, byte abyte0[], int i);

    public static native int url_feof(AVIOContext aviocontext);

    static 
    {
        Loader.load();
    }
}
