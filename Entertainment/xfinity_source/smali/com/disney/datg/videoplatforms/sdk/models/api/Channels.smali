.class public Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;
.super Ljava/lang/Object;
.source "Channels.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation runtime Lorg/simpleframework/xml/Root;
    strict = false
.end annotation


# instance fields
.field private channel:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;",
            ">;"
        }
    .end annotation

    .annotation runtime Lorg/simpleframework/xml/ElementList;
        inline = true
        required = false
    .end annotation
.end field

.field private xmlns:Ljava/lang/String;
    .annotation runtime Lorg/simpleframework/xml/Attribute;
        required = false
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    const-string v0, "http://abc.go.com/vp2/ws/xmlns"

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;->xmlns:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getChannel()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Channel;",
            ">;"
        }
    .end annotation

    .prologue
    .line 67
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;->channel:Ljava/util/ArrayList;

    return-object v0
.end method
