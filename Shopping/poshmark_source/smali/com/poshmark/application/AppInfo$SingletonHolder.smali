.class Lcom/poshmark/application/AppInfo$SingletonHolder;
.super Ljava/lang/Object;
.source "AppInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/application/AppInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingletonHolder"
.end annotation


# static fields
.field public static final INSTANCE:Lcom/poshmark/application/AppInfo;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 89
    new-instance v0, Lcom/poshmark/application/AppInfo;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/poshmark/application/AppInfo;-><init>(Lcom/poshmark/application/AppInfo$1;)V

    sput-object v0, Lcom/poshmark/application/AppInfo$SingletonHolder;->INSTANCE:Lcom/poshmark/application/AppInfo;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
