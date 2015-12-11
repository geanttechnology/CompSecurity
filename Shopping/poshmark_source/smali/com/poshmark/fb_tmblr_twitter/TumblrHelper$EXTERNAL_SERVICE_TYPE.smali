.class public final enum Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;
.super Ljava/lang/Enum;
.source "TumblrHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/fb_tmblr_twitter/TumblrHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "EXTERNAL_SERVICE_TYPE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

.field public static final enum TUMBLR:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

.field public static final enum TWITTER:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 35
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    const-string v1, "TWITTER"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;->TWITTER:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    const-string v1, "TUMBLR"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;->TUMBLR:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;->TWITTER:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;->TUMBLR:Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    aput-object v1, v0, v3

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;->$VALUES:[Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 35
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 35
    const-class v0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;->$VALUES:[Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    invoke-virtual {v0}, [Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/fb_tmblr_twitter/TumblrHelper$EXTERNAL_SERVICE_TYPE;

    return-object v0
.end method
