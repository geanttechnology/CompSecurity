.class public Lcom/newrelic/agent/android/NewRelicApplication;
.super Landroid/app/Application;
.source "NewRelicApplication.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate()V
    .locals 0

    .prologue
    .line 8
    invoke-static {p0}, Lcom/newrelic/agent/android/instrumentation/Bootstrap;->go(Landroid/content/Context;)V

    .line 9
    return-void
.end method
