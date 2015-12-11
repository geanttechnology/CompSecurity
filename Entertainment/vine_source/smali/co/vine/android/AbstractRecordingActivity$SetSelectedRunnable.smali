.class public Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;
.super Ljava/lang/Object;
.source "AbstractRecordingActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/AbstractRecordingActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "SetSelectedRunnable"
.end annotation


# instance fields
.field public final fragmentToSetSelectedFalse:Lco/vine/android/DraftFragment;

.field public final fragmentToSetSelectedTrue:Lco/vine/android/DraftFragment;

.field final synthetic this$0:Lco/vine/android/AbstractRecordingActivity;


# direct methods
.method public constructor <init>(Lco/vine/android/AbstractRecordingActivity;Lco/vine/android/DraftFragment;Lco/vine/android/DraftFragment;)V
    .locals 0
    .param p2, "fragmentToSetSelectedFalse"    # Lco/vine/android/DraftFragment;
    .param p3, "fragmentToSetSelectedTrue"    # Lco/vine/android/DraftFragment;

    .prologue
    .line 602
    iput-object p1, p0, Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;->this$0:Lco/vine/android/AbstractRecordingActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 603
    iput-object p2, p0, Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;->fragmentToSetSelectedFalse:Lco/vine/android/DraftFragment;

    .line 604
    iput-object p3, p0, Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;->fragmentToSetSelectedTrue:Lco/vine/android/DraftFragment;

    .line 605
    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 609
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;->fragmentToSetSelectedFalse:Lco/vine/android/DraftFragment;

    if-eqz v0, :cond_0

    .line 610
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;->fragmentToSetSelectedFalse:Lco/vine/android/DraftFragment;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/DraftFragment;->setSelected(Z)V

    .line 612
    :cond_0
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;->fragmentToSetSelectedTrue:Lco/vine/android/DraftFragment;

    if-eqz v0, :cond_1

    .line 613
    iget-object v0, p0, Lco/vine/android/AbstractRecordingActivity$SetSelectedRunnable;->fragmentToSetSelectedTrue:Lco/vine/android/DraftFragment;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lco/vine/android/DraftFragment;->setSelected(Z)V

    .line 615
    :cond_1
    return-void
.end method
