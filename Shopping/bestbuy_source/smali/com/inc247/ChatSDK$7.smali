.class Lcom/inc247/ChatSDK$7;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/ChatSDK;->incrementBadge()V
.end annotation


# instance fields
.field final synthetic this$0:Lcom/inc247/ChatSDK;


# direct methods
.method constructor <init>(Lcom/inc247/ChatSDK;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/ChatSDK$7;->this$0:Lcom/inc247/ChatSDK;

    .line 902
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 905
    iget-object v0, p0, Lcom/inc247/ChatSDK$7;->this$0:Lcom/inc247/ChatSDK;

    # getter for: Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/inc247/ChatSDK;->access$4(Lcom/inc247/ChatSDK;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 906
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 907
    iget-object v1, p0, Lcom/inc247/ChatSDK$7;->this$0:Lcom/inc247/ChatSDK;

    # getter for: Lcom/inc247/ChatSDK;->badgeView:Lcom/inc247/ChatSDKBadgeView;
    invoke-static {v1}, Lcom/inc247/ChatSDK;->access$6(Lcom/inc247/ChatSDK;)Lcom/inc247/ChatSDKBadgeView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/inc247/ChatSDKBadgeView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 906
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 908
    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 909
    const/16 v1, 0x9

    if-ne v0, v1, :cond_0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 910
    const-string v0, "+"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 911
    :goto_0
    iget-object v1, p0, Lcom/inc247/ChatSDK$7;->this$0:Lcom/inc247/ChatSDK;

    # getter for: Lcom/inc247/ChatSDK;->badgeView:Lcom/inc247/ChatSDKBadgeView;
    invoke-static {v1}, Lcom/inc247/ChatSDK;->access$6(Lcom/inc247/ChatSDK;)Lcom/inc247/ChatSDKBadgeView;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKBadgeView;->setText(Ljava/lang/CharSequence;)V

    .line 912
    return-void

    .line 910
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, 0x1

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
