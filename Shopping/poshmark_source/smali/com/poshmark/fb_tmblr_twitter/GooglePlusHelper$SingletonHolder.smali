.class Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$SingletonHolder;
.super Ljava/lang/Object;
.source "GooglePlusHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingletonHolder"
.end annotation


# static fields
.field public static final INSTANCE:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 38
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;-><init>(Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$1;)V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper$SingletonHolder;->INSTANCE:Lcom/poshmark/fb_tmblr_twitter/GooglePlusHelper;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
