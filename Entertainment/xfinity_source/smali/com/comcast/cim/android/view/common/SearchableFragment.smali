.class public abstract Lcom/comcast/cim/android/view/common/SearchableFragment;
.super Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;
.source "SearchableFragment.java"


# instance fields
.field protected searchable:Lcom/comcast/cim/android/view/common/Searchable;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 11
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onAttach(Landroid/app/Activity;)V

    .line 13
    instance-of v0, p1, Lcom/comcast/cim/android/view/common/Searchable;

    if-eqz v0, :cond_0

    .line 14
    check-cast p1, Lcom/comcast/cim/android/view/common/Searchable;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/SearchableFragment;->searchable:Lcom/comcast/cim/android/view/common/Searchable;

    .line 18
    :goto_0
    return-void

    .line 16
    .restart local p1    # "activity":Landroid/app/Activity;
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/SearchableFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Activity must implement Searchable"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    goto :goto_0
.end method
