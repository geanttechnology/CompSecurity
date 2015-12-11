.class public Lnet/tsz/afinal/FinalDb$DaoConfig;
.super Ljava/lang/Object;
.source "FinalDb.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lnet/tsz/afinal/FinalDb;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DaoConfig"
.end annotation


# instance fields
.field private context:Landroid/content/Context;

.field private dbName:Ljava/lang/String;

.field private dbUpdateListener:Lnet/tsz/afinal/FinalDb$DbUpdateListener;

.field private dbVersion:I

.field private debug:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 590
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 591
    const/4 v0, 0x0

    iput-object v0, p0, Lnet/tsz/afinal/FinalDb$DaoConfig;->context:Landroid/content/Context;

    .line 592
    const-string v0, "afinal.db"

    iput-object v0, p0, Lnet/tsz/afinal/FinalDb$DaoConfig;->dbName:Ljava/lang/String;

    .line 593
    iput v1, p0, Lnet/tsz/afinal/FinalDb$DaoConfig;->dbVersion:I

    .line 594
    iput-boolean v1, p0, Lnet/tsz/afinal/FinalDb$DaoConfig;->debug:Z

    .line 590
    return-void
.end method


# virtual methods
.method public getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 598
    iget-object v0, p0, Lnet/tsz/afinal/FinalDb$DaoConfig;->context:Landroid/content/Context;

    return-object v0
.end method

.method public getDbName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 604
    iget-object v0, p0, Lnet/tsz/afinal/FinalDb$DaoConfig;->dbName:Ljava/lang/String;

    return-object v0
.end method

.method public getDbUpdateListener()Lnet/tsz/afinal/FinalDb$DbUpdateListener;
    .locals 1

    .prologue
    .line 622
    iget-object v0, p0, Lnet/tsz/afinal/FinalDb$DaoConfig;->dbUpdateListener:Lnet/tsz/afinal/FinalDb$DbUpdateListener;

    return-object v0
.end method

.method public getDbVersion()I
    .locals 1

    .prologue
    .line 610
    iget v0, p0, Lnet/tsz/afinal/FinalDb$DaoConfig;->dbVersion:I

    return v0
.end method

.method public isDebug()Z
    .locals 1

    .prologue
    .line 616
    iget-boolean v0, p0, Lnet/tsz/afinal/FinalDb$DaoConfig;->debug:Z

    return v0
.end method

.method public setContext(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 601
    iput-object p1, p0, Lnet/tsz/afinal/FinalDb$DaoConfig;->context:Landroid/content/Context;

    .line 602
    return-void
.end method

.method public setDbName(Ljava/lang/String;)V
    .locals 0
    .param p1, "dbName"    # Ljava/lang/String;

    .prologue
    .line 607
    iput-object p1, p0, Lnet/tsz/afinal/FinalDb$DaoConfig;->dbName:Ljava/lang/String;

    .line 608
    return-void
.end method

.method public setDbUpdateListener(Lnet/tsz/afinal/FinalDb$DbUpdateListener;)V
    .locals 0
    .param p1, "dbUpdateListener"    # Lnet/tsz/afinal/FinalDb$DbUpdateListener;

    .prologue
    .line 625
    iput-object p1, p0, Lnet/tsz/afinal/FinalDb$DaoConfig;->dbUpdateListener:Lnet/tsz/afinal/FinalDb$DbUpdateListener;

    .line 626
    return-void
.end method

.method public setDbVersion(I)V
    .locals 0
    .param p1, "dbVersion"    # I

    .prologue
    .line 613
    iput p1, p0, Lnet/tsz/afinal/FinalDb$DaoConfig;->dbVersion:I

    .line 614
    return-void
.end method

.method public setDebug(Z)V
    .locals 0
    .param p1, "debug"    # Z

    .prologue
    .line 619
    iput-boolean p1, p0, Lnet/tsz/afinal/FinalDb$DaoConfig;->debug:Z

    .line 620
    return-void
.end method
