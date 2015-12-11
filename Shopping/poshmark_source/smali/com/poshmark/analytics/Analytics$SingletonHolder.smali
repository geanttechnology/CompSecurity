.class Lcom/poshmark/analytics/Analytics$SingletonHolder;
.super Ljava/lang/Object;
.source "Analytics.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/analytics/Analytics;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingletonHolder"
.end annotation


# static fields
.field public static final INSTANCE:Lcom/poshmark/analytics/Analytics;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 88
    new-instance v0, Lcom/poshmark/analytics/Analytics;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/poshmark/analytics/Analytics;-><init>(Lcom/poshmark/analytics/Analytics$1;)V

    sput-object v0, Lcom/poshmark/analytics/Analytics$SingletonHolder;->INSTANCE:Lcom/poshmark/analytics/Analytics;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 86
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
