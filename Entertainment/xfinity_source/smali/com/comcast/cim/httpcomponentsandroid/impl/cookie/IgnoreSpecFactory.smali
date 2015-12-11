.class public Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/IgnoreSpecFactory;
.super Ljava/lang/Object;
.source "IgnoreSpecFactory.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpecFactory;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public newInstance(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpec;
    .locals 1
    .param p1, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 44
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/IgnoreSpec;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/IgnoreSpec;-><init>()V

    return-object v0
.end method
