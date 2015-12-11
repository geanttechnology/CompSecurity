.class Lcom/poshmark/http/httpCore/PMHttpClient$SingletonHolder;
.super Ljava/lang/Object;
.source "PMHttpClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/http/httpCore/PMHttpClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingletonHolder"
.end annotation


# static fields
.field public static final INSTANCE:Lcom/poshmark/http/httpCore/PMHttpClient;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 103
    new-instance v0, Lcom/poshmark/http/httpCore/PMHttpClient;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/poshmark/http/httpCore/PMHttpClient;-><init>(Lcom/poshmark/http/httpCore/PMHttpClient$1;)V

    sput-object v0, Lcom/poshmark/http/httpCore/PMHttpClient$SingletonHolder;->INSTANCE:Lcom/poshmark/http/httpCore/PMHttpClient;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 101
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
