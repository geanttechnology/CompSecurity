.class public Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingActionBarActivity;
.super Landroid/support/v7/app/ActionBarActivity;
.source "DelegatingActionBarActivity.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private delegateList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/android/util/view/common/ActivityDelegate;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingActionBarActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingActionBarActivity;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Landroid/support/v7/app/ActionBarActivity;-><init>()V

    .line 18
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/common/DelegatingActionBarActivity;->delegateList:Ljava/util/List;

    return-void
.end method
