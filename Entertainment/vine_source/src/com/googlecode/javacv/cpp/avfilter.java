// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;

import com.googlecode.javacpp.BytePointer;
import com.googlecode.javacpp.DoublePointer;
import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.IntPointer;
import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.LongPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.PointerPointer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class avfilter
{
    public static class AVABufferSinkParams extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int all_channel_counts();

        public native AVABufferSinkParams all_channel_counts(int i);

        public native IntPointer channel_counts();

        public native LongPointer channel_layouts();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVABufferSinkParams position(int i)
        {
            return (AVABufferSinkParams)super.position(i);
        }

        public native IntPointer sample_fmts();

        public native IntPointer sample_rates();

        public native AVABufferSinkParams sample_rates(IntPointer intpointer);

        static 
        {
            Loader.load();
        }

        public AVABufferSinkParams()
        {
            allocate();
        }

        public AVABufferSinkParams(int i)
        {
            allocateArray(i);
        }

        public AVABufferSinkParams(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVBufferSinkParams extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native IntPointer pixel_fmts();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVBufferSinkParams position(int i)
        {
            return (AVBufferSinkParams)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public AVBufferSinkParams()
        {
            allocate();
        }

        public AVBufferSinkParams(int i)
        {
            allocateArray(i);
        }

        public AVBufferSinkParams(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilter extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native BytePointer description();

        public native int flags();

        public native AVFilter flags(int i);

        public native Init_AVFilterContext init();

        public native AVFilter init(Init_AVFilterContext init_avfiltercontext);

        public native Init_dict_AVFilterContext_PointerPointer init_dict();

        public native AVFilter init_dict(Init_dict_AVFilterContext_PointerPointer init_dict_avfiltercontext_pointerpointer);

        public native Init_opaque_AVFilterContext_Pointer init_opaque();

        public native AVFilter init_opaque(Init_opaque_AVFilterContext_Pointer init_opaque_avfiltercontext_pointer);

        public native AVFilterPad inputs();

        public native BytePointer name();

        public native AVFilter next();

        public native AVFilter next(AVFilter avfilter1);

        public native AVFilterPad outputs();

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVFilter position(int i)
        {
            return (AVFilter)super.position(i);
        }

        public native avutil.AVClass priv_class();

        public native int priv_size();

        public native AVFilter priv_size(int i);

        public native Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int process_command();

        public native AVFilter process_command(Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int process_command_avfiltercontext_bytepointer_bytepointer_bytepointer_int_int);

        public native Query_formats_AVFilterContext query_formats();

        public native AVFilter query_formats(Query_formats_AVFilterContext query_formats_avfiltercontext);

        public native Uninit_AVFilterContext uninit();

        public native AVFilter uninit(Uninit_AVFilterContext uninit_avfiltercontext);

        static 
        {
            Loader.load();
        }

        public AVFilter()
        {
            allocate();
        }

        public AVFilter(int i)
        {
            allocateArray(i);
        }

        public AVFilter(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilter.Init_AVFilterContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFilterContext avfiltercontext);

        static 
        {
            Loader.load();
        }

        protected AVFilter.Init_AVFilterContext()
        {
            allocate();
        }

        public AVFilter.Init_AVFilterContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilter.Init_dict_AVFilterContext_PointerPointer extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFilterContext avfiltercontext, PointerPointer pointerpointer);

        static 
        {
            Loader.load();
        }

        protected AVFilter.Init_dict_AVFilterContext_PointerPointer()
        {
            allocate();
        }

        public AVFilter.Init_dict_AVFilterContext_PointerPointer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilter.Init_opaque_AVFilterContext_Pointer extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFilterContext avfiltercontext, Pointer pointer);

        static 
        {
            Loader.load();
        }

        protected AVFilter.Init_opaque_AVFilterContext_Pointer()
        {
            allocate();
        }

        public AVFilter.Init_opaque_AVFilterContext_Pointer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilter.Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFilterContext avfiltercontext, BytePointer bytepointer, BytePointer bytepointer1, BytePointer bytepointer2, int i, int j);

        static 
        {
            Loader.load();
        }

        protected AVFilter.Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int()
        {
            allocate();
        }

        public AVFilter.Process_command_AVFilterContext_BytePointer_BytePointer_BytePointer_int_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilter.Query_formats_AVFilterContext extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFilterContext avfiltercontext);

        static 
        {
            Loader.load();
        }

        protected AVFilter.Query_formats_AVFilterContext()
        {
            allocate();
        }

        public AVFilter.Query_formats_AVFilterContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilter.Uninit_AVFilterContext extends FunctionPointer
    {

        private native void allocate();

        public native void call(AVFilterContext avfiltercontext);

        static 
        {
            Loader.load();
        }

        protected AVFilter.Uninit_AVFilterContext()
        {
            allocate();
        }

        public AVFilter.Uninit_AVFilterContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterBuffer extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native BytePointer data(int i);

        public native PointerPointer data();

        public native AVFilterBuffer data(int i, BytePointer bytepointer);

        public native BytePointer extended_data(int i);

        public native PointerPointer extended_data();

        public native AVFilterBuffer extended_data(int i, BytePointer bytepointer);

        public native int format();

        public native AVFilterBuffer format(int i);

        public native Free_AVFilterBuffer free();

        public native AVFilterBuffer free(Free_AVFilterBuffer free_avfilterbuffer);

        public native int h();

        public native AVFilterBuffer h(int i);

        public native int linesize(int i);

        public native IntPointer linesize();

        public native AVFilterBuffer linesize(int i, int j);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVFilterBuffer position(int i)
        {
            return (AVFilterBuffer)super.position(i);
        }

        public native Pointer priv();

        public native AVFilterBuffer priv(Pointer pointer);

        public native int refcount();

        public native AVFilterBuffer refcount(int i);

        public native int w();

        public native AVFilterBuffer w(int i);

        static 
        {
            Loader.load();
        }

        public AVFilterBuffer()
        {
            allocate();
        }

        public AVFilterBuffer(int i)
        {
            allocateArray(i);
        }

        public AVFilterBuffer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterBuffer.Free_AVFilterBuffer extends FunctionPointer
    {

        private native void allocate();

        public native void call(AVFilterBuffer avfilterbuffer);

        static 
        {
            Loader.load();
        }

        protected AVFilterBuffer.Free_AVFilterBuffer()
        {
            allocate();
        }

        public AVFilterBuffer.Free_AVFilterBuffer(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterBufferRef extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native AVFilterBufferRef audio(AVFilterBufferRefAudioProps avfilterbufferrefaudioprops);

        public native AVFilterBufferRefAudioProps audio();

        public native AVFilterBuffer buf();

        public native AVFilterBufferRef buf(AVFilterBuffer avfilterbuffer);

        public native BytePointer data(int i);

        public native PointerPointer data();

        public native AVFilterBufferRef data(int i, BytePointer bytepointer);

        public native BytePointer extended_data(int i);

        public native PointerPointer extended_data();

        public native AVFilterBufferRef extended_data(int i, BytePointer bytepointer);

        public native int format();

        public native AVFilterBufferRef format(int i);

        public native int linesize(int i);

        public native IntPointer linesize();

        public native AVFilterBufferRef linesize(int i, int j);

        public native AVFilterBufferRef metadata(avutil.AVDictionary avdictionary);

        public native avutil.AVDictionary metadata();

        public native int perms();

        public native AVFilterBufferRef perms(int i);

        public native long pos();

        public native AVFilterBufferRef pos(long l);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVFilterBufferRef position(int i)
        {
            return (AVFilterBufferRef)super.position(i);
        }

        public native long pts();

        public native AVFilterBufferRef pts(long l);

        public native int type();

        public native AVFilterBufferRef type(int i);

        public native AVFilterBufferRef video(AVFilterBufferRefVideoProps avfilterbufferrefvideoprops);

        public native AVFilterBufferRefVideoProps video();

        static 
        {
            Loader.load();
        }

        public AVFilterBufferRef()
        {
            allocate();
        }

        public AVFilterBufferRef(int i)
        {
            allocateArray(i);
        }

        public AVFilterBufferRef(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterBufferRefAudioProps extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native long channel_layout();

        public native AVFilterBufferRefAudioProps channel_layout(long l);

        public native int channels();

        public native AVFilterBufferRefAudioProps channels(int i);

        public native int nb_samples();

        public native AVFilterBufferRefAudioProps nb_samples(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVFilterBufferRefAudioProps position(int i)
        {
            return (AVFilterBufferRefAudioProps)super.position(i);
        }

        public native int sample_rate();

        public native AVFilterBufferRefAudioProps sample_rate(int i);

        static 
        {
            Loader.load();
        }

        public AVFilterBufferRefAudioProps()
        {
            allocate();
        }

        public AVFilterBufferRefAudioProps(int i)
        {
            allocateArray(i);
        }

        public AVFilterBufferRefAudioProps(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterBufferRefVideoProps extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native int h();

        public native AVFilterBufferRefVideoProps h(int i);

        public native int interlaced();

        public native AVFilterBufferRefVideoProps interlaced(int i);

        public native int key_frame();

        public native AVFilterBufferRefVideoProps key_frame(int i);

        public native int pict_type();

        public native AVFilterBufferRefVideoProps pict_type(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVFilterBufferRefVideoProps position(int i)
        {
            return (AVFilterBufferRefVideoProps)super.position(i);
        }

        public native BytePointer qp_table();

        public native AVFilterBufferRefVideoProps qp_table(BytePointer bytepointer);

        public native int qp_table_linesize();

        public native AVFilterBufferRefVideoProps qp_table_linesize(int i);

        public native int qp_table_size();

        public native AVFilterBufferRefVideoProps qp_table_size(int i);

        public native AVFilterBufferRefVideoProps sample_aspect_ratio(avutil.AVRational avrational);

        public native avutil.AVRational sample_aspect_ratio();

        public native int top_field_first();

        public native AVFilterBufferRefVideoProps top_field_first(int i);

        public native int w();

        public native AVFilterBufferRefVideoProps w(int i);

        static 
        {
            Loader.load();
        }

        public AVFilterBufferRefVideoProps()
        {
            allocate();
        }

        public AVFilterBufferRefVideoProps(int i)
        {
            allocateArray(i);
        }

        public AVFilterBufferRefVideoProps(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterContext extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native avutil.AVClass av_class();

        public native Pointer command_queue();

        public native AVFilterContext command_queue(Pointer pointer);

        public native Pointer enable();

        public native AVFilterContext enable(Pointer pointer);

        public native BytePointer enable_str();

        public native AVFilterContext enable_str(BytePointer bytepointer);

        public native AVFilter filter();

        public native AVFilterContext graph(AVFilterGraph avfiltergraph);

        public native AVFilterGraph graph();

        public native AVFilterContext input_pads(AVFilterPad avfilterpad);

        public native AVFilterPad input_pads();

        public native PointerPointer inputs();

        public native AVFilterContext inputs(int i, AVFilterLink avfilterlink);

        public native AVFilterLink inputs(int i);

        public native AVFilterContext internal(AVFilterInternal avfilterinternal);

        public native AVFilterInternal internal();

        public native int is_disabled();

        public native AVFilterContext is_disabled(int i);

        public native BytePointer name();

        public native AVFilterContext name(BytePointer bytepointer);

        public native int nb_inputs();

        public native AVFilterContext nb_inputs(int i);

        public native int nb_outputs();

        public native AVFilterContext nb_outputs(int i);

        public native AVFilterContext output_pads(AVFilterPad avfilterpad);

        public native AVFilterPad output_pads();

        public native PointerPointer outputs();

        public native AVFilterContext outputs(int i, AVFilterLink avfilterlink);

        public native AVFilterLink outputs(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVFilterContext position(int i)
        {
            return (AVFilterContext)super.position(i);
        }

        public native Pointer priv();

        public native AVFilterContext priv(Pointer pointer);

        public native int thread_type();

        public native AVFilterContext thread_type(int i);

        public native DoublePointer var_values();

        public native AVFilterContext var_values(DoublePointer doublepointer);

        static 
        {
            Loader.load();
        }

        public AVFilterContext()
        {
            allocate();
        }

        public AVFilterContext(int i)
        {
            allocateArray(i);
        }

        public AVFilterContext(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterFormats extends Pointer
    {

        public AVFilterFormats()
        {
        }

        public AVFilterFormats(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterGraph extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native BytePointer aresample_swr_opts();

        public native AVFilterGraph aresample_swr_opts(BytePointer bytepointer);

        public native avutil.AVClass av_class();

        public native int disable_auto_convert();

        public native AVFilterGraph disable_auto_convert(int i);

        public native PointerPointer filters();

        public native AVFilterContext filters(int i);

        public native AVFilterGraph filters(int i, AVFilterContext avfiltercontext);

        public native AVFilterGraph internal(AVFilterGraphInternal avfiltergraphinternal);

        public native AVFilterGraphInternal internal();

        public native int nb_threads();

        public native AVFilterGraph nb_threads(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVFilterGraph position(int i)
        {
            return (AVFilterGraph)super.position(i);
        }

        public native BytePointer resample_lavr_opts();

        public native AVFilterGraph resample_lavr_opts(BytePointer bytepointer);

        public native BytePointer scale_sws_opts();

        public native AVFilterGraph scale_sws_opts(BytePointer bytepointer);

        public native PointerPointer sink_links();

        public native AVFilterGraph sink_links(int i, AVFilterLink avfilterlink);

        public native AVFilterLink sink_links(int i);

        public native int sink_links_count();

        public native AVFilterGraph sink_links_count(int i);

        public native int thread_type();

        public native AVFilterGraph thread_type(int i);

        static 
        {
            Loader.load();
        }

        public AVFilterGraph()
        {
            allocate();
        }

        public AVFilterGraph(int i)
        {
            allocateArray(i);
        }

        public AVFilterGraph(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterGraphInternal extends Pointer
    {

        public AVFilterGraphInternal()
        {
        }

        public AVFilterGraphInternal(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterInOut extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native AVFilterContext filter_ctx();

        public native AVFilterInOut filter_ctx(AVFilterContext avfiltercontext);

        public native BytePointer name();

        public native AVFilterInOut name(BytePointer bytepointer);

        public native AVFilterInOut next();

        public native AVFilterInOut next(AVFilterInOut avfilterinout);

        public native int pad_idx();

        public native AVFilterInOut pad_idx(int i);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVFilterInOut position(int i)
        {
            return (AVFilterInOut)super.position(i);
        }

        static 
        {
            Loader.load();
        }

        public AVFilterInOut()
        {
            allocate();
        }

        public AVFilterInOut(int i)
        {
            allocateArray(i);
        }

        public AVFilterInOut(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterInternal extends Pointer
    {

        public AVFilterInternal()
        {
        }

        public AVFilterInternal(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterLink extends Pointer
    {

        public static final int AVLINK_INIT = 2;
        public static final int AVLINK_STARTINIT = 1;
        public static final int AVLINK_UNINIT = 0;

        private native void allocate();

        private native void allocateArray(int i);

        public native int age_index();

        public native AVFilterLink age_index(int i);

        public native long channel_layout();

        public native AVFilterLink channel_layout(long l);

        public native int channels();

        public native AVFilterLink channels(int i);

        public native int closed();

        public native AVFilterLink closed(int i);

        public native AVFilterBufferRef cur_buf_copy();

        public native AVFilterLink cur_buf_copy(AVFilterBufferRef avfilterbufferref);

        public native long current_pts();

        public native AVFilterLink current_pts(long l);

        public native AVFilterContext dst();

        public native AVFilterLink dst(AVFilterContext avfiltercontext);

        public native AVFilterLink dstpad(AVFilterPad avfilterpad);

        public native AVFilterPad dstpad();

        public native int flags();

        public native AVFilterLink flags(int i);

        public native int format();

        public native AVFilterLink format(int i);

        public native long frame_count();

        public native AVFilterLink frame_count(long l);

        public native AVFilterLink frame_rate(avutil.AVRational avrational);

        public native avutil.AVRational frame_rate();

        public native int frame_requested();

        public native AVFilterLink frame_requested(int i);

        public native AVFilterGraph graph();

        public native AVFilterLink graph(AVFilterGraph avfiltergraph);

        public native int h();

        public native AVFilterLink h(int i);

        public native Pointer in_channel_layouts();

        public native AVFilterLink in_channel_layouts(Pointer pointer);

        public native AVFilterFormats in_formats();

        public native AVFilterLink in_formats(AVFilterFormats avfilterformats);

        public native AVFilterFormats in_samplerates();

        public native AVFilterLink in_samplerates(AVFilterFormats avfilterformats);

        public native int max_samples();

        public native AVFilterLink max_samples(int i);

        public native int min_samples();

        public native AVFilterLink min_samples(int i);

        public native Pointer out_channel_layouts();

        public native AVFilterLink out_channel_layouts(Pointer pointer);

        public native AVFilterFormats out_formats();

        public native AVFilterLink out_formats(AVFilterFormats avfilterformats);

        public native AVFilterFormats out_samplerates();

        public native AVFilterLink out_samplerates(AVFilterFormats avfilterformats);

        public native AVFilterLink partial_buf(avutil.AVFrame avframe);

        public native avutil.AVFrame partial_buf();

        public native int partial_buf_size();

        public native AVFilterLink partial_buf_size(int i);

        public native Pointer pool();

        public native AVFilterLink pool(Pointer pointer);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVFilterLink position(int i)
        {
            return (AVFilterLink)super.position(i);
        }

        public native int request_samples();

        public native AVFilterLink request_samples(int i);

        public native AVFilterLink sample_aspect_ratio(avutil.AVRational avrational);

        public native avutil.AVRational sample_aspect_ratio();

        public native int sample_rate();

        public native AVFilterLink sample_rate(int i);

        public native AVFilterContext src();

        public native AVFilterLink src(AVFilterContext avfiltercontext);

        public native AVFilterLink srcpad(AVFilterPad avfilterpad);

        public native AVFilterPad srcpad();

        public native AVFilterLink time_base(avutil.AVRational avrational);

        public native avutil.AVRational time_base();

        public native int type();

        public native AVFilterLink type(int i);

        public native int w();

        public native AVFilterLink w(int i);

        static 
        {
            Loader.load();
        }

        public AVFilterLink()
        {
            allocate();
        }

        public AVFilterLink(int i)
        {
            allocateArray(i);
        }

        public AVFilterLink(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterPad extends Pointer
    {

        private native void allocate();

        private native void allocateArray(int i);

        public native Config_props_AVFilterLink config_props();

        public native AVFilterPad config_props(Config_props_AVFilterLink config_props_avfilterlink);

        public native Draw_slice_AVFilterLink_int_int_int draw_slice();

        public native AVFilterPad draw_slice(Draw_slice_AVFilterLink_int_int_int draw_slice_avfilterlink_int_int_int);

        public native End_frame_AVFilterLink end_frame();

        public native AVFilterPad end_frame(End_frame_AVFilterLink end_frame_avfilterlink);

        public native Filter_frame_AVFilterLink_AVFrame filter_frame();

        public native AVFilterPad filter_frame(Filter_frame_AVFilterLink_AVFrame filter_frame_avfilterlink_avframe);

        public native Get_audio_buffer_AVFilterLink_int get_audio_buffer();

        public native AVFilterPad get_audio_buffer(Get_audio_buffer_AVFilterLink_int get_audio_buffer_avfilterlink_int);

        public native Get_video_buffer_AVFilterLink_int_int get_video_buffer();

        public native AVFilterPad get_video_buffer(Get_video_buffer_AVFilterLink_int_int get_video_buffer_avfilterlink_int_int);

        public native int min_perms();

        public native AVFilterPad min_perms(int i);

        public native BytePointer name();

        public native int needs_fifo();

        public native AVFilterPad needs_fifo(int i);

        public native int needs_writable();

        public native AVFilterPad needs_writable(int i);

        public native Poll_frame_AVFilterLink poll_frame();

        public native AVFilterPad poll_frame(Poll_frame_AVFilterLink poll_frame_avfilterlink);

        public volatile Pointer position(int i)
        {
            return position(i);
        }

        public AVFilterPad position(int i)
        {
            return (AVFilterPad)super.position(i);
        }

        public native int rej_perms();

        public native AVFilterPad rej_perms(int i);

        public native Request_frame_AVFilterLink request_frame();

        public native AVFilterPad request_frame(Request_frame_AVFilterLink request_frame_avfilterlink);

        public native Start_frame_AVFilterLink_AVFilterBufferRef start_frame();

        public native AVFilterPad start_frame(Start_frame_AVFilterLink_AVFilterBufferRef start_frame_avfilterlink_avfilterbufferref);

        public native int type();

        public native AVFilterPad type(int i);

        static 
        {
            Loader.load();
        }

        public AVFilterPad()
        {
            allocate();
        }

        public AVFilterPad(int i)
        {
            allocateArray(i);
        }

        public AVFilterPad(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterPad.Config_props_AVFilterLink extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFilterLink avfilterlink);

        static 
        {
            Loader.load();
        }

        protected AVFilterPad.Config_props_AVFilterLink()
        {
            allocate();
        }

        public AVFilterPad.Config_props_AVFilterLink(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterPad.Draw_slice_AVFilterLink_int_int_int extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFilterLink avfilterlink, int i, int j, int k);

        static 
        {
            Loader.load();
        }

        protected AVFilterPad.Draw_slice_AVFilterLink_int_int_int()
        {
            allocate();
        }

        public AVFilterPad.Draw_slice_AVFilterLink_int_int_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterPad.End_frame_AVFilterLink extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFilterLink avfilterlink);

        static 
        {
            Loader.load();
        }

        protected AVFilterPad.End_frame_AVFilterLink()
        {
            allocate();
        }

        public AVFilterPad.End_frame_AVFilterLink(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterPad.Filter_frame_AVFilterLink_AVFrame extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFilterLink avfilterlink, avutil.AVFrame avframe);

        static 
        {
            Loader.load();
        }

        protected AVFilterPad.Filter_frame_AVFilterLink_AVFrame()
        {
            allocate();
        }

        public AVFilterPad.Filter_frame_AVFilterLink_AVFrame(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterPad.Get_audio_buffer_AVFilterLink_int extends FunctionPointer
    {

        private native void allocate();

        public native avutil.AVFrame call(AVFilterLink avfilterlink, int i);

        static 
        {
            Loader.load();
        }

        protected AVFilterPad.Get_audio_buffer_AVFilterLink_int()
        {
            allocate();
        }

        public AVFilterPad.Get_audio_buffer_AVFilterLink_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterPad.Get_video_buffer_AVFilterLink_int_int extends FunctionPointer
    {

        private native void allocate();

        public native avutil.AVFrame call(AVFilterLink avfilterlink, int i, int j);

        static 
        {
            Loader.load();
        }

        protected AVFilterPad.Get_video_buffer_AVFilterLink_int_int()
        {
            allocate();
        }

        public AVFilterPad.Get_video_buffer_AVFilterLink_int_int(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterPad.Poll_frame_AVFilterLink extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFilterLink avfilterlink);

        static 
        {
            Loader.load();
        }

        protected AVFilterPad.Poll_frame_AVFilterLink()
        {
            allocate();
        }

        public AVFilterPad.Poll_frame_AVFilterLink(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterPad.Request_frame_AVFilterLink extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFilterLink avfilterlink);

        static 
        {
            Loader.load();
        }

        protected AVFilterPad.Request_frame_AVFilterLink()
        {
            allocate();
        }

        public AVFilterPad.Request_frame_AVFilterLink(Pointer pointer)
        {
            super(pointer);
        }
    }

    public static class AVFilterPad.Start_frame_AVFilterLink_AVFilterBufferRef extends FunctionPointer
    {

        private native void allocate();

        public native int call(AVFilterLink avfilterlink, AVFilterBufferRef avfilterbufferref);

        static 
        {
            Loader.load();
        }

        protected AVFilterPad.Start_frame_AVFilterLink_AVFilterBufferRef()
        {
            allocate();
        }

        public AVFilterPad.Start_frame_AVFilterLink_AVFilterBufferRef(Pointer pointer)
        {
            super(pointer);
        }
    }


    public static final int AVFILTER_ALIGN = 16;
    public static final int AVFILTER_AUTO_CONVERT_ALL = 0;
    public static final int AVFILTER_AUTO_CONVERT_NONE = -1;
    public static final int AVFILTER_CMD_FLAG_FAST = 2;
    public static final int AVFILTER_CMD_FLAG_ONE = 1;
    public static final int AVFILTER_FLAG_DYNAMIC_INPUTS = 1;
    public static final int AVFILTER_FLAG_DYNAMIC_OUTPUTS = 2;
    public static final int AVFILTER_FLAG_SLICE_THREADS = 4;
    public static final int AVFILTER_FLAG_SUPPORT_TIMELINE = 0x30000;
    public static final int AVFILTER_FLAG_SUPPORT_TIMELINE_GENERIC = 0x10000;
    public static final int AVFILTER_FLAG_SUPPORT_TIMELINE_INTERNAL = 0x20000;
    public static final int AVFILTER_THREAD_SLICE = 1;
    public static final int AV_BUFFERSINK_FLAG_NO_REQUEST = 2;
    public static final int AV_BUFFERSINK_FLAG_PEEK = 1;
    public static final int AV_BUFFERSRC_FLAG_KEEP_REF = 8;
    public static final int AV_BUFFERSRC_FLAG_NO_CHECK_FORMAT = 1;
    public static final int AV_BUFFERSRC_FLAG_NO_COPY = 2;
    public static final int AV_BUFFERSRC_FLAG_PUSH = 4;
    public static final int AV_PERM_ALIGN = 64;
    public static final int AV_PERM_NEG_LINESIZES = 32;
    public static final int AV_PERM_PRESERVE = 4;
    public static final int AV_PERM_READ = 1;
    public static final int AV_PERM_REUSE = 8;
    public static final int AV_PERM_REUSE2 = 16;
    public static final int AV_PERM_WRITE = 2;

    public avfilter()
    {
    }

    public static native AVABufferSinkParams av_abuffersink_params_alloc();

    public static native int av_buffersink_get_buffer_ref(AVFilterContext avfiltercontext, PointerPointer pointerpointer, int i);

    public static native int av_buffersink_get_buffer_ref(AVFilterContext avfiltercontext, AVFilterBufferRef avfilterbufferref, int i);

    public static native int av_buffersink_get_frame(AVFilterContext avfiltercontext, avutil.AVFrame avframe);

    public static native int av_buffersink_get_frame_flags(AVFilterContext avfiltercontext, avutil.AVFrame avframe, int i);

    public static native avutil.AVRational av_buffersink_get_frame_rate(AVFilterContext avfiltercontext);

    public static native int av_buffersink_get_samples(AVFilterContext avfiltercontext, avutil.AVFrame avframe, int i);

    public static native AVBufferSinkParams av_buffersink_params_alloc();

    public static native int av_buffersink_poll_frame(AVFilterContext avfiltercontext);

    public static native int av_buffersink_read(AVFilterContext avfiltercontext, PointerPointer pointerpointer);

    public static native int av_buffersink_read(AVFilterContext avfiltercontext, AVFilterBufferRef avfilterbufferref);

    public static native int av_buffersink_read_samples(AVFilterContext avfiltercontext, PointerPointer pointerpointer, int i);

    public static native int av_buffersink_read_samples(AVFilterContext avfiltercontext, AVFilterBufferRef avfilterbufferref, int i);

    public static native void av_buffersink_set_frame_size(AVFilterContext avfiltercontext, int i);

    public static native int av_buffersrc_add_frame(AVFilterContext avfiltercontext, avutil.AVFrame avframe);

    public static native int av_buffersrc_add_frame_flags(AVFilterContext avfiltercontext, avutil.AVFrame avframe, int i);

    public static native int av_buffersrc_add_ref(AVFilterContext avfiltercontext, AVFilterBufferRef avfilterbufferref, int i);

    public static native int av_buffersrc_buffer(AVFilterContext avfiltercontext, AVFilterBufferRef avfilterbufferref);

    public static native int av_buffersrc_get_nb_failed_requests(AVFilterContext avfiltercontext);

    public static native int av_buffersrc_write_frame(AVFilterContext avfiltercontext, avutil.AVFrame avframe);

    public static native PointerPointer av_filter_next(PointerPointer pointerpointer);

    public static native AVFilter av_filter_next(AVFilter avfilter1);

    public static native int avfilter_config_links(AVFilterContext avfiltercontext);

    public static native BytePointer avfilter_configuration();

    public static native int avfilter_copy_buf_props(avutil.AVFrame avframe, AVFilterBufferRef avfilterbufferref);

    public static native void avfilter_copy_buffer_ref_props(AVFilterBufferRef avfilterbufferref, AVFilterBufferRef avfilterbufferref1);

    public static native int avfilter_copy_frame_props(AVFilterBufferRef avfilterbufferref, avutil.AVFrame avframe);

    public static native void avfilter_free(AVFilterContext avfiltercontext);

    public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays(BytePointer bytepointer, int i, int j, int k, int l, long l1);

    public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays(PointerPointer pointerpointer, int i, int j, int k, int l, long l1);

    public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays(ByteBuffer bytebuffer, int i, int j, int k, int l, long l1);

    public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays(byte abyte0[], int i, int j, int k, int l, long l1);

    public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays_channels(BytePointer bytepointer, int i, int j, int k, int l, int i1, long l1);

    public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays_channels(PointerPointer pointerpointer, int i, int j, int k, int l, int i1, long l1);

    public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays_channels(ByteBuffer bytebuffer, int i, int j, int k, int l, int i1, long l1);

    public static native AVFilterBufferRef avfilter_get_audio_buffer_ref_from_arrays_channels(byte abyte0[], int i, int j, int k, int l, int i1, long l1);

    public static native AVFilter avfilter_get_by_name(BytePointer bytepointer);

    public static native AVFilter avfilter_get_by_name(String s);

    public static native avutil.AVClass avfilter_get_class();

    public static native AVFilterBufferRef avfilter_get_video_buffer_ref_from_arrays(BytePointer bytepointer, IntPointer intpointer, int i, int j, int k, int l);

    public static native AVFilterBufferRef avfilter_get_video_buffer_ref_from_arrays(PointerPointer pointerpointer, IntPointer intpointer, int i, int j, int k, int l);

    public static native AVFilterBufferRef avfilter_get_video_buffer_ref_from_arrays(ByteBuffer bytebuffer, IntBuffer intbuffer, int i, int j, int k, int l);

    public static native AVFilterBufferRef avfilter_get_video_buffer_ref_from_arrays(byte abyte0[], int ai[], int i, int j, int k, int l);

    public static native int avfilter_graph_add_filter(AVFilterGraph avfiltergraph, AVFilterContext avfiltercontext);

    public static native AVFilterGraph avfilter_graph_alloc();

    public static native AVFilterContext avfilter_graph_alloc_filter(AVFilterGraph avfiltergraph, AVFilter avfilter1, BytePointer bytepointer);

    public static native AVFilterContext avfilter_graph_alloc_filter(AVFilterGraph avfiltergraph, AVFilter avfilter1, String s);

    public static native int avfilter_graph_config(AVFilterGraph avfiltergraph, Pointer pointer);

    public static native int avfilter_graph_create_filter(PointerPointer pointerpointer, AVFilter avfilter1, BytePointer bytepointer, BytePointer bytepointer1, Pointer pointer, AVFilterGraph avfiltergraph);

    public static native int avfilter_graph_create_filter(AVFilterContext avfiltercontext, AVFilter avfilter1, BytePointer bytepointer, BytePointer bytepointer1, Pointer pointer, AVFilterGraph avfiltergraph);

    public static native int avfilter_graph_create_filter(AVFilterContext avfiltercontext, AVFilter avfilter1, String s, String s1, Pointer pointer, AVFilterGraph avfiltergraph);

    public static native BytePointer avfilter_graph_dump(AVFilterGraph avfiltergraph, BytePointer bytepointer);

    public static native ByteBuffer avfilter_graph_dump(AVFilterGraph avfiltergraph, String s);

    public static native void avfilter_graph_free(PointerPointer pointerpointer);

    public static native void avfilter_graph_free(AVFilterGraph avfiltergraph);

    public static native AVFilterContext avfilter_graph_get_filter(AVFilterGraph avfiltergraph, BytePointer bytepointer);

    public static native AVFilterContext avfilter_graph_get_filter(AVFilterGraph avfiltergraph, ByteBuffer bytebuffer);

    public static native AVFilterContext avfilter_graph_get_filter(AVFilterGraph avfiltergraph, byte abyte0[]);

    public static native int avfilter_graph_parse(AVFilterGraph avfiltergraph, BytePointer bytepointer, PointerPointer pointerpointer, PointerPointer pointerpointer1, Pointer pointer);

    public static native int avfilter_graph_parse(AVFilterGraph avfiltergraph, BytePointer bytepointer, AVFilterInOut avfilterinout, AVFilterInOut avfilterinout1, Pointer pointer);

    public static native int avfilter_graph_parse(AVFilterGraph avfiltergraph, String s, AVFilterInOut avfilterinout, AVFilterInOut avfilterinout1, Pointer pointer);

    public static native int avfilter_graph_parse2(AVFilterGraph avfiltergraph, BytePointer bytepointer, PointerPointer pointerpointer, PointerPointer pointerpointer1);

    public static native int avfilter_graph_parse2(AVFilterGraph avfiltergraph, BytePointer bytepointer, AVFilterInOut avfilterinout, AVFilterInOut avfilterinout1);

    public static native int avfilter_graph_parse2(AVFilterGraph avfiltergraph, String s, AVFilterInOut avfilterinout, AVFilterInOut avfilterinout1);

    public static native int avfilter_graph_parse_ptr(AVFilterGraph avfiltergraph, BytePointer bytepointer, PointerPointer pointerpointer, PointerPointer pointerpointer1, Pointer pointer);

    public static native int avfilter_graph_parse_ptr(AVFilterGraph avfiltergraph, BytePointer bytepointer, AVFilterInOut avfilterinout, AVFilterInOut avfilterinout1, Pointer pointer);

    public static native int avfilter_graph_parse_ptr(AVFilterGraph avfiltergraph, String s, AVFilterInOut avfilterinout, AVFilterInOut avfilterinout1, Pointer pointer);

    public static native int avfilter_graph_queue_command(AVFilterGraph avfiltergraph, BytePointer bytepointer, BytePointer bytepointer1, BytePointer bytepointer2, int i, double d);

    public static native int avfilter_graph_queue_command(AVFilterGraph avfiltergraph, String s, String s1, String s2, int i, double d);

    public static native int avfilter_graph_request_oldest(AVFilterGraph avfiltergraph);

    public static native int avfilter_graph_send_command(AVFilterGraph avfiltergraph, BytePointer bytepointer, BytePointer bytepointer1, BytePointer bytepointer2, BytePointer bytepointer3, int i, int j);

    public static native int avfilter_graph_send_command(AVFilterGraph avfiltergraph, BytePointer bytepointer, BytePointer bytepointer1, BytePointer bytepointer2, ByteBuffer bytebuffer, int i, int j);

    public static native int avfilter_graph_send_command(AVFilterGraph avfiltergraph, BytePointer bytepointer, BytePointer bytepointer1, BytePointer bytepointer2, byte abyte0[], int i, int j);

    public static native int avfilter_graph_send_command(AVFilterGraph avfiltergraph, String s, String s1, String s2, BytePointer bytepointer, int i, int j);

    public static native int avfilter_graph_send_command(AVFilterGraph avfiltergraph, String s, String s1, String s2, ByteBuffer bytebuffer, int i, int j);

    public static native int avfilter_graph_send_command(AVFilterGraph avfiltergraph, String s, String s1, String s2, byte abyte0[], int i, int j);

    public static native void avfilter_graph_set_auto_convert(AVFilterGraph avfiltergraph, int i);

    public static native int avfilter_init_dict(AVFilterContext avfiltercontext, PointerPointer pointerpointer);

    public static native int avfilter_init_dict(AVFilterContext avfiltercontext, avutil.AVDictionary avdictionary);

    public static native int avfilter_init_filter(AVFilterContext avfiltercontext, BytePointer bytepointer, Pointer pointer);

    public static native int avfilter_init_filter(AVFilterContext avfiltercontext, String s, Pointer pointer);

    public static native int avfilter_init_str(AVFilterContext avfiltercontext, BytePointer bytepointer);

    public static native int avfilter_init_str(AVFilterContext avfiltercontext, String s);

    public static native AVFilterInOut avfilter_inout_alloc();

    public static native void avfilter_inout_free(PointerPointer pointerpointer);

    public static native void avfilter_inout_free(AVFilterInOut avfilterinout);

    public static native int avfilter_insert_filter(AVFilterLink avfilterlink, AVFilterContext avfiltercontext, int i, int j);

    public static native BytePointer avfilter_license();

    public static native int avfilter_link(AVFilterContext avfiltercontext, int i, AVFilterContext avfiltercontext1, int j);

    public static native void avfilter_link_free(PointerPointer pointerpointer);

    public static native void avfilter_link_free(AVFilterLink avfilterlink);

    public static native int avfilter_link_get_channels(AVFilterLink avfilterlink);

    public static native void avfilter_link_set_closed(AVFilterLink avfilterlink, int i);

    public static native AVFilter avfilter_next(AVFilter avfilter1);

    public static native int avfilter_open(PointerPointer pointerpointer, AVFilter avfilter1, BytePointer bytepointer);

    public static native int avfilter_open(AVFilterContext avfiltercontext, AVFilter avfilter1, BytePointer bytepointer);

    public static native int avfilter_open(AVFilterContext avfiltercontext, AVFilter avfilter1, String s);

    public static native int avfilter_pad_count(AVFilterPad avfilterpad);

    public static native BytePointer avfilter_pad_get_name(AVFilterPad avfilterpad, int i);

    public static native int avfilter_pad_get_type(AVFilterPad avfilterpad, int i);

    public static native int avfilter_process_command(AVFilterContext avfiltercontext, BytePointer bytepointer, BytePointer bytepointer1, BytePointer bytepointer2, int i, int j);

    public static native int avfilter_process_command(AVFilterContext avfiltercontext, BytePointer bytepointer, BytePointer bytepointer1, ByteBuffer bytebuffer, int i, int j);

    public static native int avfilter_process_command(AVFilterContext avfiltercontext, BytePointer bytepointer, BytePointer bytepointer1, byte abyte0[], int i, int j);

    public static native int avfilter_process_command(AVFilterContext avfiltercontext, String s, String s1, BytePointer bytepointer, int i, int j);

    public static native int avfilter_process_command(AVFilterContext avfiltercontext, String s, String s1, ByteBuffer bytebuffer, int i, int j);

    public static native int avfilter_process_command(AVFilterContext avfiltercontext, String s, String s1, byte abyte0[], int i, int j);

    public static native AVFilterBufferRef avfilter_ref_buffer(AVFilterBufferRef avfilterbufferref, int i);

    public static native int avfilter_ref_get_channels(AVFilterBufferRef avfilterbufferref);

    public static native int avfilter_register(AVFilter avfilter1);

    public static native void avfilter_register_all();

    public static native void avfilter_uninit();

    public static native void avfilter_unref_buffer(AVFilterBufferRef avfilterbufferref);

    public static native void avfilter_unref_bufferp(PointerPointer pointerpointer);

    public static native void avfilter_unref_bufferp(AVFilterBufferRef avfilterbufferref);

    public static native int avfilter_version();

    static 
    {
        Loader.load();
    }
}
