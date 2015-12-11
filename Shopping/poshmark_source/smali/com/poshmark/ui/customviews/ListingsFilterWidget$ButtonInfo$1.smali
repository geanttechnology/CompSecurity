.class Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo$1;
.super Ljava/lang/Object;
.source "ListingsFilterWidget.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;-><init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget;Ljava/lang/String;Lcom/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON;IIII)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

.field final synthetic val$filter_action:I

.field final synthetic val$this$0:Lcom/poshmark/ui/customviews/ListingsFilterWidget;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;Lcom/poshmark/ui/customviews/ListingsFilterWidget;I)V
    .locals 0

    .prologue
    .line 349
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo$1;->this$1:Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo;

    iput-object p2, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo$1;->val$this$0:Lcom/poshmark/ui/customviews/ListingsFilterWidget;

    iput p3, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo$1;->val$filter_action:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 352
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 353
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "FILTER_ACTION"

    iget v2, p0, Lcom/poshmark/ui/customviews/ListingsFilterWidget$ButtonInfo$1;->val$filter_action:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 354
    const-string v1, "com.poshmark.intents.FILTER_SELECTION_ACTION"

    invoke-static {v1, v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 355
    return-void
.end method
