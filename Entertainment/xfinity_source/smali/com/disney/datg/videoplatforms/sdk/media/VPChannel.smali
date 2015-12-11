.class public Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;
.super Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
.source "VPChannel.java"


# static fields
.field private static MEDIA_TYPE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->LIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->MEDIA_TYPE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 4
    invoke-direct {p0}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;-><init>()V

    return-void
.end method


# virtual methods
.method public getMediaType()Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPChannel;->MEDIA_TYPE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    return-object v0
.end method
