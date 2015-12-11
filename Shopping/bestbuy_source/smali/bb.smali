.class public final Lbb;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static a(Ljava/io/InputStream;)Lorg/json/JSONObject;
    .locals 2

    .prologue
    .line 20
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-static {p0}, Lbc;->a(Ljava/io/InputStream;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 24
    invoke-static {p0}, Lbc;->a(Ljava/io/Closeable;)V

    :goto_0
    return-object v0

    .line 22
    :catch_0
    move-exception v0

    invoke-static {p0}, Lbc;->a(Ljava/io/Closeable;)V

    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-static {p0}, Lbc;->a(Ljava/io/Closeable;)V

    throw v0
.end method
