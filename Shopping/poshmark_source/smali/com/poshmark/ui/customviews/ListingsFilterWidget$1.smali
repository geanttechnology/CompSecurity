.class Lcom/poshmark/ui/customviews/ListingsFilterWidget$1;
.super Ljava/lang/Object;
.source "ListingsFilterWidget.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/ListingsFilterWidget;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/ListingsFilterWidget;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;)V
    .locals 0

    .prologue
    .line 285
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$1;->this$0:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 288
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 289
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "FILTER_ACTION"

    const/16 v2, 0x10

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 290
    const-string v1, "com.poshmark.intents.FILTER_SELECTION_ACTION"

    invoke-static {v1, v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 291
    return-void
.end method
