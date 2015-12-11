.class final enum Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;
.super Ljava/lang/Enum;
.source "VideoPlayerFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "BabyGuideType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

.field public static final enum BOOKMARKS:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

.field public static final enum HISTORY:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

.field public static final enum INFO:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;


# instance fields
.field private final resStringCaptionId:I


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 250
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    const-string v1, "INFO"

    sget v2, Lcom/xfinity/playerlib/R$string;->details:I

    invoke-direct {v0, v1, v3, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->INFO:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    .line 251
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    const-string v1, "HISTORY"

    sget v2, Lcom/xfinity/playerlib/R$string;->history:I

    invoke-direct {v0, v1, v4, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->HISTORY:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    .line 252
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    const-string v1, "BOOKMARKS"

    sget v2, Lcom/xfinity/playerlib/R$string;->favorite:I

    invoke-direct {v0, v1, v5, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->BOOKMARKS:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    .line 248
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    sget-object v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->INFO:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->HISTORY:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->BOOKMARKS:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->$VALUES:[Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "resStringCaptionId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 256
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 257
    iput p3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->resStringCaptionId:I

    .line 258
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 248
    const-class v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;
    .locals 1

    .prologue
    .line 248
    sget-object v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->$VALUES:[Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    return-object v0
.end method


# virtual methods
.method public getCaptionResId()I
    .locals 1

    .prologue
    .line 261
    iget v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;->resStringCaptionId:I

    return v0
.end method
