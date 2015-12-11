.class public final enum Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;
.super Ljava/lang/Enum;
.source "FbHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/fb_tmblr_twitter/FbHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AccessLevel"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

.field public static final enum ACCESS_LEVEL_PUBLISH:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

.field public static final enum ACCESS_LEVEL_READ:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

.field public static final enum ACCESS_LEVEL_READ_PLUS_EMAIL:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

.field public static final enum ACCESS_LEVEL_READ_PLUS_EMAIL_PLUS_FRIENDS:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

.field public static final enum ACCESS_LEVEL_READ_PLUS_FRIENDS:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

.field public static final enum ACCESS_LEVEL_UNKNOWN:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 64
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    const-string v1, "ACCESS_LEVEL_UNKNOWN"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;->ACCESS_LEVEL_UNKNOWN:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    const-string v1, "ACCESS_LEVEL_READ"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;->ACCESS_LEVEL_READ:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    const-string v1, "ACCESS_LEVEL_READ_PLUS_EMAIL"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;->ACCESS_LEVEL_READ_PLUS_EMAIL:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    const-string v1, "ACCESS_LEVEL_READ_PLUS_EMAIL_PLUS_FRIENDS"

    invoke-direct {v0, v1, v6}, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;->ACCESS_LEVEL_READ_PLUS_EMAIL_PLUS_FRIENDS:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    .line 65
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    const-string v1, "ACCESS_LEVEL_READ_PLUS_FRIENDS"

    invoke-direct {v0, v1, v7}, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;->ACCESS_LEVEL_READ_PLUS_FRIENDS:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    const-string v1, "ACCESS_LEVEL_PUBLISH"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;->ACCESS_LEVEL_PUBLISH:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    .line 64
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;->ACCESS_LEVEL_UNKNOWN:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;->ACCESS_LEVEL_READ:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;->ACCESS_LEVEL_READ_PLUS_EMAIL:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    aput-object v1, v0, v5

    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;->ACCESS_LEVEL_READ_PLUS_EMAIL_PLUS_FRIENDS:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    aput-object v1, v0, v6

    sget-object v1, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;->ACCESS_LEVEL_READ_PLUS_FRIENDS:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;->ACCESS_LEVEL_PUBLISH:Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    aput-object v2, v0, v1

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;->$VALUES:[Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

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
    .line 64
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 64
    const-class v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;
    .locals 1

    .prologue
    .line 64
    sget-object v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;->$VALUES:[Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    invoke-virtual {v0}, [Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/fb_tmblr_twitter/FbHelper$AccessLevel;

    return-object v0
.end method
