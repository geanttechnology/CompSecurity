.class public Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;
.super Ljava/lang/Object;
.source "PlaybackSupportResponse.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/avod/sdk/PlaybackSupportResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PlaybackSupport"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport$Factory;
    }
.end annotation


# static fields
.field public static final FULL_SUPPORT:Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;


# instance fields
.field private final mIsPlaybackSupported:Z

.field private final mIsPlaybackSustainable:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 17
    new-instance v0, Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;

    invoke-direct {v0, v1, v1}, Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;-><init>(ZZ)V

    sput-object v0, Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;->FULL_SUPPORT:Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;

    return-void
.end method

.method private constructor <init>(ZZ)V
    .locals 0
    .param p1, "isPlaybackSupported"    # Z
    .param p2, "isPlaybackSustainable"    # Z

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-boolean p1, p0, Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;->mIsPlaybackSupported:Z

    .line 24
    iput-boolean p2, p0, Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;->mIsPlaybackSustainable:Z

    .line 25
    return-void
.end method

.method synthetic constructor <init>(ZZLcom/amazon/avod/sdk/PlaybackSupportResponse$1;)V
    .locals 0
    .param p1, "x0"    # Z
    .param p2, "x1"    # Z
    .param p3, "x2"    # Lcom/amazon/avod/sdk/PlaybackSupportResponse$1;

    .prologue
    .line 11
    invoke-direct {p0, p1, p2}, Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;-><init>(ZZ)V

    return-void
.end method


# virtual methods
.method public isPlaybackSupported()Z
    .locals 1

    .prologue
    .line 38
    iget-boolean v0, p0, Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;->mIsPlaybackSupported:Z

    return v0
.end method

.method public isPlaybackSustainable()Z
    .locals 1

    .prologue
    .line 51
    iget-boolean v0, p0, Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;->mIsPlaybackSustainable:Z

    return v0
.end method
