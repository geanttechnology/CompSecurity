.class Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;
.super Lnet/tsz/afinal/core/AsyncTask;
.source "FinalBitmap.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lnet/tsz/afinal/FinalBitmap;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CacheExecutecTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lnet/tsz/afinal/core/AsyncTask",
        "<",
        "Ljava/lang/Object;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# static fields
.field public static final MESSAGE_CLEAR:I = 0x0

.field public static final MESSAGE_CLEAR_DISK:I = 0x5

.field public static final MESSAGE_CLEAR_KEY:I = 0x6

.field public static final MESSAGE_CLEAR_KEY_IN_DISK:I = 0x8

.field public static final MESSAGE_CLEAR_KEY_IN_MEMORY:I = 0x7

.field public static final MESSAGE_CLEAR_MEMORY:I = 0x4

.field public static final MESSAGE_CLOSE:I = 0x3

.field public static final MESSAGE_FLUSH:I = 0x2

.field public static final MESSAGE_INIT_DISK_CACHE:I = 0x1


# instance fields
.field final synthetic this$0:Lnet/tsz/afinal/FinalBitmap;


# direct methods
.method private constructor <init>(Lnet/tsz/afinal/FinalBitmap;)V
    .locals 0

    .prologue
    .line 796
    iput-object p1, p0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->this$0:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {p0}, Lnet/tsz/afinal/core/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lnet/tsz/afinal/FinalBitmap;Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;)V
    .locals 0

    .prologue
    .line 796
    invoke-direct {p0, p1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;-><init>(Lnet/tsz/afinal/FinalBitmap;)V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Object;

    invoke-virtual {p0, p1}, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->doInBackground([Ljava/lang/Object;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Object;)Ljava/lang/Void;
    .locals 2
    .param p1, "params"    # [Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    .line 808
    const/4 v0, 0x0

    aget-object v0, p1, v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 838
    :goto_0
    const/4 v0, 0x0

    return-object v0

    .line 810
    :pswitch_0
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->this$0:Lnet/tsz/afinal/FinalBitmap;

    # invokes: Lnet/tsz/afinal/FinalBitmap;->clearCacheInternalInBackgroud()V
    invoke-static {v0}, Lnet/tsz/afinal/FinalBitmap;->access$0(Lnet/tsz/afinal/FinalBitmap;)V

    goto :goto_0

    .line 813
    :pswitch_1
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->this$0:Lnet/tsz/afinal/FinalBitmap;

    # invokes: Lnet/tsz/afinal/FinalBitmap;->initDiskCacheInternalInBackgroud()V
    invoke-static {v0}, Lnet/tsz/afinal/FinalBitmap;->access$1(Lnet/tsz/afinal/FinalBitmap;)V

    goto :goto_0

    .line 816
    :pswitch_2
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->this$0:Lnet/tsz/afinal/FinalBitmap;

    # invokes: Lnet/tsz/afinal/FinalBitmap;->clearMemoryCacheInBackgroud()V
    invoke-static {v0}, Lnet/tsz/afinal/FinalBitmap;->access$2(Lnet/tsz/afinal/FinalBitmap;)V

    .line 817
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->this$0:Lnet/tsz/afinal/FinalBitmap;

    # invokes: Lnet/tsz/afinal/FinalBitmap;->flushCacheInternalInBackgroud()V
    invoke-static {v0}, Lnet/tsz/afinal/FinalBitmap;->access$3(Lnet/tsz/afinal/FinalBitmap;)V

    goto :goto_0

    .line 820
    :pswitch_3
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->this$0:Lnet/tsz/afinal/FinalBitmap;

    # invokes: Lnet/tsz/afinal/FinalBitmap;->clearMemoryCacheInBackgroud()V
    invoke-static {v0}, Lnet/tsz/afinal/FinalBitmap;->access$2(Lnet/tsz/afinal/FinalBitmap;)V

    .line 821
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->this$0:Lnet/tsz/afinal/FinalBitmap;

    # invokes: Lnet/tsz/afinal/FinalBitmap;->closeCacheInternalInBackgroud()V
    invoke-static {v0}, Lnet/tsz/afinal/FinalBitmap;->access$4(Lnet/tsz/afinal/FinalBitmap;)V

    .line 823
    :pswitch_4
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->this$0:Lnet/tsz/afinal/FinalBitmap;

    # invokes: Lnet/tsz/afinal/FinalBitmap;->clearMemoryCacheInBackgroud()V
    invoke-static {v0}, Lnet/tsz/afinal/FinalBitmap;->access$2(Lnet/tsz/afinal/FinalBitmap;)V

    goto :goto_0

    .line 826
    :pswitch_5
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->this$0:Lnet/tsz/afinal/FinalBitmap;

    # invokes: Lnet/tsz/afinal/FinalBitmap;->clearDiskCacheInBackgroud()V
    invoke-static {v0}, Lnet/tsz/afinal/FinalBitmap;->access$5(Lnet/tsz/afinal/FinalBitmap;)V

    goto :goto_0

    .line 829
    :pswitch_6
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->this$0:Lnet/tsz/afinal/FinalBitmap;

    aget-object v1, p1, v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    # invokes: Lnet/tsz/afinal/FinalBitmap;->clearCacheInBackgroud(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lnet/tsz/afinal/FinalBitmap;->access$6(Lnet/tsz/afinal/FinalBitmap;Ljava/lang/String;)V

    goto :goto_0

    .line 832
    :pswitch_7
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->this$0:Lnet/tsz/afinal/FinalBitmap;

    aget-object v1, p1, v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    # invokes: Lnet/tsz/afinal/FinalBitmap;->clearMemoryCacheInBackgroud(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lnet/tsz/afinal/FinalBitmap;->access$7(Lnet/tsz/afinal/FinalBitmap;Ljava/lang/String;)V

    goto :goto_0

    .line 835
    :pswitch_8
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap$CacheExecutecTask;->this$0:Lnet/tsz/afinal/FinalBitmap;

    aget-object v1, p1, v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    # invokes: Lnet/tsz/afinal/FinalBitmap;->clearDiskCacheInBackgroud(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lnet/tsz/afinal/FinalBitmap;->access$8(Lnet/tsz/afinal/FinalBitmap;Ljava/lang/String;)V

    goto :goto_0

    .line 808
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch
.end method
