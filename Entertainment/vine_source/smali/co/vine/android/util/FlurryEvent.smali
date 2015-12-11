.class public Lco/vine/android/util/FlurryEvent;
.super Ljava/lang/Object;
.source "FlurryEvent.java"


# instance fields
.field private final mEventName:Ljava/lang/String;

.field public mInfo:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "eventName"    # Ljava/lang/String;

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object p1, p0, Lco/vine/android/util/FlurryEvent;->mEventName:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public static log(Ljava/lang/String;)V
    .locals 0
    .param p0, "event"    # Ljava/lang/String;

    .prologue
    .line 24
    invoke-static {p0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 25
    return-void
.end method

.method public static log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p0, "eventName"    # Ljava/lang/String;
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 20
    new-instance v0, Lco/vine/android/util/FlurryEvent;

    invoke-direct {v0, p0}, Lco/vine/android/util/FlurryEvent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1, p2}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/util/FlurryEvent;->log()V

    .line 21
    return-void
.end method

.method public static log(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p0, "eventName"    # Ljava/lang/String;
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;
    .param p3, "key2"    # Ljava/lang/String;
    .param p4, "value2"    # Ljava/lang/Object;

    .prologue
    .line 16
    new-instance v0, Lco/vine/android/util/FlurryEvent;

    invoke-direct {v0, p0}, Lco/vine/android/util/FlurryEvent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1, p2}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    move-result-object v0

    invoke-virtual {v0, p3, p4}, Lco/vine/android/util/FlurryEvent;->add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/util/FlurryEvent;->log()V

    .line 17
    return-void
.end method


# virtual methods
.method public add(Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/FlurryEvent;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 28
    iget-object v0, p0, Lco/vine/android/util/FlurryEvent;->mInfo:Ljava/util/HashMap;

    if-nez v0, :cond_0

    .line 29
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/util/FlurryEvent;->mInfo:Ljava/util/HashMap;

    .line 31
    :cond_0
    iget-object v0, p0, Lco/vine/android/util/FlurryEvent;->mInfo:Ljava/util/HashMap;

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 32
    return-object p0
.end method

.method public log()V
    .locals 2

    .prologue
    .line 40
    iget-object v0, p0, Lco/vine/android/util/FlurryEvent;->mInfo:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    .line 41
    iget-object v0, p0, Lco/vine/android/util/FlurryEvent;->mEventName:Ljava/lang/String;

    iget-object v1, p0, Lco/vine/android/util/FlurryEvent;->mInfo:Ljava/util/HashMap;

    invoke-static {v0, v1}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 45
    :goto_0
    return-void

    .line 43
    :cond_0
    iget-object v0, p0, Lco/vine/android/util/FlurryEvent;->mEventName:Ljava/lang/String;

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    goto :goto_0
.end method
