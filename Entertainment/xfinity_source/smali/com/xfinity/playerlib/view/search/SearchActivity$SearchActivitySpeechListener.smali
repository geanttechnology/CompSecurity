.class public Lcom/xfinity/playerlib/view/search/SearchActivity$SearchActivitySpeechListener;
.super Lcom/comcast/cim/android/view/common/BaseActivity$ActivitySpeechListener;
.source "SearchActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/search/SearchActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "SearchActivitySpeechListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/search/SearchActivity;


# direct methods
.method protected constructor <init>(Lcom/xfinity/playerlib/view/search/SearchActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/search/SearchActivity;

    .prologue
    .line 148
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchActivity$SearchActivitySpeechListener;->this$0:Lcom/xfinity/playerlib/view/search/SearchActivity;

    invoke-direct {p0, p1}, Lcom/comcast/cim/android/view/common/BaseActivity$ActivitySpeechListener;-><init>(Lcom/comcast/cim/android/view/common/BaseActivity;)V

    return-void
.end method


# virtual methods
.method public onSpeechResponseSearch([Ljava/lang/String;)Z
    .locals 1
    .param p1, "searchTerms"    # [Ljava/lang/String;

    .prologue
    .line 152
    const/4 v0, 0x0

    return v0
.end method
