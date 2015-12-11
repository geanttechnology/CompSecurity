.class final Lcom/mobileapptracker/r;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/mobileapptracker/MobileAppTracker;


# direct methods
.method constructor <init>(Lcom/mobileapptracker/MobileAppTracker;)V
    .locals 0

    iput-object p1, p0, Lcom/mobileapptracker/r;->a:Lcom/mobileapptracker/MobileAppTracker;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    iget-object v0, p0, Lcom/mobileapptracker/r;->a:Lcom/mobileapptracker/MobileAppTracker;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/mobileapptracker/MobileAppTracker;->notifiedPool:Z

    iget-object v0, p0, Lcom/mobileapptracker/r;->a:Lcom/mobileapptracker/MobileAppTracker;

    new-instance v1, Lcom/mobileapptracker/MATEvent;

    const-string v2, "session"

    invoke-direct {v1, v2}, Lcom/mobileapptracker/MATEvent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/mobileapptracker/MobileAppTracker;->measureEvent(Lcom/mobileapptracker/MATEvent;)V

    return-void
.end method
