.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$1;
.super Ljava/lang/Object;
.source "PlayNowPreferenceDelegate.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->onPostExecute(Ljava/util/List;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;

.field final synthetic val$button:Lcom/xfinity/playerlib/view/settings/ButtonPreference;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;Lcom/xfinity/playerlib/view/settings/ButtonPreference;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;

    .prologue
    .line 395
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$1;->this$1:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$1;->val$button:Lcom/xfinity/playerlib/view/settings/ButtonPreference;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 398
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$1;->val$button:Lcom/xfinity/playerlib/view/settings/ButtonPreference;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->showProgress()V

    .line 399
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$1;->this$1:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->unregisterDevice()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1400(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V

    .line 400
    return-void
.end method
