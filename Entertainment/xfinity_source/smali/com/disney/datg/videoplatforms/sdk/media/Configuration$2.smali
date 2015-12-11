.class final Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;
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
        "Ljava/util/Map",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/String;",
        ">;>;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    .line 61
    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 64
    const-string v0, "comcast"

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$1;

    invoke-direct {v1, p0}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$1;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;)V

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    const-string v0, "charter"

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$2;

    invoke-direct {v1, p0}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$2;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;)V

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 80
    const-string v0, "att"

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$3;

    invoke-direct {v1, p0}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$3;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;)V

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 88
    const-string v0, "verizon"

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$4;

    invoke-direct {v1, p0}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$4;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;)V

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    const-string v0, "dish"

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$5;

    invoke-direct {v1, p0}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$5;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;)V

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 104
    const-string v0, "cox"

    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$6;

    invoke-direct {v1, p0}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$6;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;)V

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 111
    return-void
.end method
