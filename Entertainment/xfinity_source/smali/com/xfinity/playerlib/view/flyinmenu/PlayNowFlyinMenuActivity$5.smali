.class Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$5;
.super Ljava/lang/Object;
.source "PlayNowFlyinMenuActivity.java"

# interfaces
.implements Landroid/widget/TextView$OnEditorActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    .prologue
    .line 231
    iput-object p1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$5;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "v"    # Landroid/widget/TextView;
    .param p2, "actionId"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v0, 0x0

    .line 234
    const/4 v1, 0x6

    if-ne p2, v1, :cond_0

    .line 235
    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$5;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    # getter for: Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->inputMethodManager:Landroid/view/inputmethod/InputMethodManager;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->access$300(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)Landroid/view/inputmethod/InputMethodManager;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$5;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    # getter for: Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchEditText:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->access$000(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)Landroid/widget/EditText;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 236
    const/4 v0, 0x1

    .line 238
    :cond_0
    return v0
.end method
