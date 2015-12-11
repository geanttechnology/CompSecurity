.class Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/SearchView$OnQueryTextListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;)V
    .locals 0

    .prologue
    .line 161
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onQueryTextChange(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 171
    const/4 v0, 0x0

    return v0
.end method

.method public onQueryTextSubmit(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->a(Ljava/lang/String;)V

    .line 166
    const/4 v0, 0x0

    return v0
.end method
