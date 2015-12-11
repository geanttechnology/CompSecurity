.class Lcom/kochava/android/tracker/Feature$TrackTask;
.super Ljava/lang/Object;
.source "Feature.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/kochava/android/tracker/Feature;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TrackTask"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/kochava/android/tracker/Feature;


# direct methods
.method private constructor <init>(Lcom/kochava/android/tracker/Feature;)V
    .locals 0

    .prologue
    .line 2311
    iput-object p1, p0, Lcom/kochava/android/tracker/Feature$TrackTask;->this$0:Lcom/kochava/android/tracker/Feature;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/kochava/android/tracker/Feature;Lcom/kochava/android/tracker/Feature$TrackTask;)V
    .locals 0

    .prologue
    .line 2311
    invoke-direct {p0, p1}, Lcom/kochava/android/tracker/Feature$TrackTask;-><init>(Lcom/kochava/android/tracker/Feature;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 2316
    iget-object v0, p0, Lcom/kochava/android/tracker/Feature$TrackTask;->this$0:Lcom/kochava/android/tracker/Feature;

    # invokes: Lcom/kochava/android/tracker/Feature;->postEvent()Ljava/lang/String;
    invoke-static {v0}, Lcom/kochava/android/tracker/Feature;->access$35(Lcom/kochava/android/tracker/Feature;)Ljava/lang/String;

    .line 2317
    return-void
.end method
