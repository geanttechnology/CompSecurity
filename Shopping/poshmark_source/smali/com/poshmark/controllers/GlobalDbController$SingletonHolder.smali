.class Lcom/poshmark/controllers/GlobalDbController$SingletonHolder;
.super Ljava/lang/Object;
.source "GlobalDbController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/controllers/GlobalDbController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingletonHolder"
.end annotation


# static fields
.field public static final INSTANCE:Lcom/poshmark/controllers/GlobalDbController;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 48
    new-instance v0, Lcom/poshmark/controllers/GlobalDbController;

    invoke-direct {v0}, Lcom/poshmark/controllers/GlobalDbController;-><init>()V

    sput-object v0, Lcom/poshmark/controllers/GlobalDbController$SingletonHolder;->INSTANCE:Lcom/poshmark/controllers/GlobalDbController;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
