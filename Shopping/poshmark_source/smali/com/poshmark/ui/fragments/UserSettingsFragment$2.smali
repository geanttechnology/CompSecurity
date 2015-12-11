.class Lcom/poshmark/ui/fragments/UserSettingsFragment$2;
.super Ljava/lang/Object;
.source "UserSettingsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/UserSettingsFragment;->setupButtons()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/UserSettingsFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V
    .locals 0

    .prologue
    .line 284
    iput-object p1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment$2;->this$0:Lcom/poshmark/ui/fragments/UserSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 287
    const/4 v0, 0x0

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->logout(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 288
    const-string v0, "com.poshmark.intents.INITIATE_LOGOUT"

    invoke-static {v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 289
    return-void
.end method
