.class Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderActivity$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderActivity;->a()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderActivity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderActivity;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 46
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderActivity;->finish()V

    .line 48
    return-void
.end method
