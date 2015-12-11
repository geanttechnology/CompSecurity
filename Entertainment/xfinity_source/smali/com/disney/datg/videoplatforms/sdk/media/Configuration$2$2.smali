.class Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$2;
.super Ljava/util/HashMap;
.source "Configuration.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
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


# instance fields
.field final synthetic this$0:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;


# direct methods
.method constructor <init>(Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;)V
    .locals 2

    .prologue
    .line 73
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$2;->this$0:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;

    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 75
    const-string v0, "partnerCode"

    const-string v1, "22"

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$2;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 76
    const-string v0, "apiKey"

    const-string v1, "3msg9wn459hgdcy2kwq4bpba"

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2$2;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 77
    return-void
.end method
