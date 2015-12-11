.class Lcom/poshmark/utils/ShareManager_Old$ShareManagerHolder;
.super Ljava/lang/Object;
.source "ShareManager_Old.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/ShareManager_Old;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ShareManagerHolder"
.end annotation


# static fields
.field static final INSTANCE:Lcom/poshmark/utils/ShareManager_Old;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 103
    new-instance v0, Lcom/poshmark/utils/ShareManager_Old;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/poshmark/utils/ShareManager_Old;-><init>(Lcom/poshmark/utils/ShareManager_Old$1;)V

    sput-object v0, Lcom/poshmark/utils/ShareManager_Old$ShareManagerHolder;->INSTANCE:Lcom/poshmark/utils/ShareManager_Old;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
