.class public Lcom/espn/androidplayersdk/datamanager/ParserException;
.super Ljava/lang/RuntimeException;
.source "ParserException.java"


# static fields
.field private static final serialVersionUID:J = -0x15d3ac272dc80afcL


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/RuntimeException;-><init>()V

    .line 11
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;I)V
    .locals 1
    .param p1, "ctx"    # Landroid/content/Context;
    .param p2, "resId"    # I

    .prologue
    .line 22
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 23
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;ILjava/lang/Exception;)V
    .locals 1
    .param p1, "ctx"    # Landroid/content/Context;
    .param p2, "resId"    # I
    .param p3, "e"    # Ljava/lang/Exception;

    .prologue
    .line 26
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, p3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 27
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "detailMessage"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 19
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "detailMessage"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 14
    invoke-direct {p0, p1, p2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 15
    return-void
.end method

.method public constructor <init>(Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    .line 31
    return-void
.end method
