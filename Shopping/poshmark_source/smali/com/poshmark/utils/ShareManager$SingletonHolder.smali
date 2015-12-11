.class Lcom/poshmark/utils/ShareManager$SingletonHolder;
.super Ljava/lang/Object;
.source "ShareManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/ShareManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingletonHolder"
.end annotation


# static fields
.field public static final INSTANCE:Lcom/poshmark/utils/ShareManager;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 45
    new-instance v0, Lcom/poshmark/utils/ShareManager;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/poshmark/utils/ShareManager;-><init>(Lcom/poshmark/utils/ShareManager$1;)V

    sput-object v0, Lcom/poshmark/utils/ShareManager$SingletonHolder;->INSTANCE:Lcom/poshmark/utils/ShareManager;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
