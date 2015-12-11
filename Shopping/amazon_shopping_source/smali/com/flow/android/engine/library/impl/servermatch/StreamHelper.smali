.class public Lcom/flow/android/engine/library/impl/servermatch/StreamHelper;
.super Ljava/lang/Object;
.source "StreamHelper.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static closeInputStream(Ljava/io/InputStream;)V
    .locals 1
    .param p0, "a_s"    # Ljava/io/InputStream;

    .prologue
    .line 49
    if-eqz p0, :cond_0

    .line 51
    :try_start_0
    invoke-virtual {p0}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 54
    :cond_0
    :goto_0
    return-void

    .line 52
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public static closeOutputStream(Ljava/io/OutputStream;)V
    .locals 1
    .param p0, "a_s"    # Ljava/io/OutputStream;

    .prologue
    .line 23
    if-eqz p0, :cond_0

    .line 25
    :try_start_0
    invoke-virtual {p0}, Ljava/io/OutputStream;->flush()V

    .line 26
    invoke-virtual {p0}, Ljava/io/OutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 29
    :cond_0
    :goto_0
    return-void

    .line 27
    :catch_0
    move-exception v0

    goto :goto_0
.end method
