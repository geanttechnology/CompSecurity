.class Lcom/poshmark/fb_tmblr_twitter/FbHelper$SingletonHolder;
.super Ljava/lang/Object;
.source "FbHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/fb_tmblr_twitter/FbHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingletonHolder"
.end annotation


# static fields
.field public static final INSTANCE:Lcom/poshmark/fb_tmblr_twitter/FbHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 54
    new-instance v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;-><init>(Lcom/poshmark/fb_tmblr_twitter/FbHelper$1;)V

    sput-object v0, Lcom/poshmark/fb_tmblr_twitter/FbHelper$SingletonHolder;->INSTANCE:Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
