.class Lhw$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhw;->c()V
.end annotation


# instance fields
.field final synthetic a:Lhw;


# direct methods
.method constructor <init>(Lhw;)V
    .locals 0

    .prologue
    .line 61
    iput-object p1, p0, Lhw$2;->a:Lhw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 64
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 65
    iget-object v0, p0, Lhw$2;->a:Lhw;

    invoke-static {v0}, Lhw;->a(Lhw;)Landroid/app/Activity;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;

    if-eqz v0, :cond_0

    .line 66
    iget-object v0, p0, Lhw$2;->a:Lhw;

    invoke-static {v0}, Lhw;->a(Lhw;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDateTimeSelectionActivity;->a()V

    .line 68
    :cond_0
    return-void
.end method
