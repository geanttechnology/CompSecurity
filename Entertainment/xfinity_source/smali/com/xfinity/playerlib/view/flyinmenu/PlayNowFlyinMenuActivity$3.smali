.class Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$3;
.super Ljava/lang/Object;
.source "PlayNowFlyinMenuActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    .line 205
    iput-object p1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$3;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 208
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$3;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    # getter for: Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->access$100(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$3;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    # getter for: Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchEditText:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->access$000(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)Landroid/widget/EditText;

    move-result-object v1

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 209
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$3;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->stopSpeaking()V

    .line 210
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$3;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->getSpeechDelegate()Lcom/comcast/cim/android/accessibility/SpeechDelegate;

    move-result-object v0

    const-class v1, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->getSpeechInput(Ljava/lang/Class;)V

    .line 211
    return-void
.end method
