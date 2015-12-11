.class Lcom/poshmark/utils/PoshLearnManager$SingletonHolder;
.super Ljava/lang/Object;
.source "PoshLearnManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/PoshLearnManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingletonHolder"
.end annotation


# static fields
.field public static final INSTANCE:Lcom/poshmark/utils/PoshLearnManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    new-instance v0, Lcom/poshmark/utils/PoshLearnManager;

    invoke-direct {v0}, Lcom/poshmark/utils/PoshLearnManager;-><init>()V

    sput-object v0, Lcom/poshmark/utils/PoshLearnManager$SingletonHolder;->INSTANCE:Lcom/poshmark/utils/PoshLearnManager;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
