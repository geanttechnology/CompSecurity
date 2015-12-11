.class final Lcom/disney/datg/videoplatforms/sdk/media/Configuration$1;
.super Ljava/util/HashMap;
.source "Configuration.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 50
    const-string v0, "001"

    const-string v1, "abc"

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    const-string v0, "002"

    const-string v1, "abcf"

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    const-string v0, "004"

    const-string v1, "dc"

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    const-string v0, "008"

    const-string v1, "djr"

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    const-string v0, "009"

    const-string v1, "dxd"

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 55
    return-void
.end method
