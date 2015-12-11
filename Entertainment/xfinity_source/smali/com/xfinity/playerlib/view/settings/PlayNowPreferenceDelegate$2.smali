.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$2;
.super Ljava/lang/Object;
.source "PlayNowPreferenceDelegate.java"

# interfaces
.implements Landroid/preference/Preference$OnPreferenceClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->initPreferences()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 136
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$2;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreferenceClick(Landroid/preference/Preference;)Z
    .locals 1
    .param p1, "preference"    # Landroid/preference/Preference;

    .prologue
    .line 139
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$2;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->signout()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$300(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V

    .line 140
    const/4 v0, 0x1

    return v0
.end method
