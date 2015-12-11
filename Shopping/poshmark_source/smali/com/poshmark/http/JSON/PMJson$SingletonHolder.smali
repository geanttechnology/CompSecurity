.class Lcom/poshmark/http/JSON/PMJson$SingletonHolder;
.super Ljava/lang/Object;
.source "PMJson.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/http/JSON/PMJson;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingletonHolder"
.end annotation


# static fields
.field private static final INSTANCE:Lcom/poshmark/http/JSON/PMJson;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 33
    new-instance v0, Lcom/poshmark/http/JSON/PMJson;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/poshmark/http/JSON/PMJson;-><init>(Lcom/poshmark/http/JSON/PMJson$1;)V

    sput-object v0, Lcom/poshmark/http/JSON/PMJson$SingletonHolder;->INSTANCE:Lcom/poshmark/http/JSON/PMJson;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000()Lcom/poshmark/http/JSON/PMJson;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lcom/poshmark/http/JSON/PMJson$SingletonHolder;->INSTANCE:Lcom/poshmark/http/JSON/PMJson;

    return-object v0
.end method
