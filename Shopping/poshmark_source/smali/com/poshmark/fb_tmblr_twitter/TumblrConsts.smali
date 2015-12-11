.class public final enum Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;
.super Ljava/lang/Enum;
.source "TumblrConsts.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

.field public static final enum AccessTokenUrl:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

.field public static final enum AuthorizeUrl:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

.field public static final enum ConsumerKey:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

.field public static final enum ConsumerSecret:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

.field public static final enum RequestUrl:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;


# instance fields
.field private final value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 4
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    const-string v1, "ConsumerKey"

    const-string v2, "DjPW0QuHLfatyEJs5ss8NzgaIhcgB1uHv27mvfl4wsOQ3HBnqb"

    invoke-direct {v0, v1, v3, v2}, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->ConsumerKey:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    .line 5
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    const-string v1, "ConsumerSecret"

    const-string v2, "v00N3KJBNwnYFVKvWtPBBT75IWkitMpFSB7SBrgoOgNdHJeDcI"

    invoke-direct {v0, v1, v4, v2}, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->ConsumerSecret:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    .line 6
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    const-string v1, "RequestUrl"

    const-string v2, "https://www.tumblr.com/oauth/request_token"

    invoke-direct {v0, v1, v5, v2}, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->RequestUrl:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    .line 7
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    const-string v1, "AccessTokenUrl"

    const-string v2, "https://www.tumblr.com/oauth/access_token"

    invoke-direct {v0, v1, v6, v2}, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->AccessTokenUrl:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    .line 8
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    const-string v1, "AuthorizeUrl"

    const-string v2, "https://www.tumblr.com/oauth/authorize"

    invoke-direct {v0, v1, v7, v2}, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->AuthorizeUrl:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    .line 3
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->ConsumerKey:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->ConsumerSecret:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->RequestUrl:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->AccessTokenUrl:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    aput-object v1, v0, v6

    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->AuthorizeUrl:Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    aput-object v1, v0, v7

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->$VALUES:[Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 12
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 13
    iput-object p3, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->value:Ljava/lang/String;

    .line 14
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 3
    const-class v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->$VALUES:[Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    invoke-virtual {v0}, [Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->value:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    invoke-virtual {p0}, Lcom/poshmark/fb_tmblr_twitter/TumblrConsts;->getValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
