.class public Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;
.super Ljava/lang/Object;
.source "EPCatalogManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "Lock"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;


# direct methods
.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;)V
    .locals 0

    .prologue
    .line 534
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Lock;->this$0:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 536
    return-void
.end method


# virtual methods
.method protected finalize()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 540
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 542
    return-void
.end method
