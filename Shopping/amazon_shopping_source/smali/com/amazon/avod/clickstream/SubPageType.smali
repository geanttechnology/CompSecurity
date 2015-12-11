.class public interface abstract Lcom/amazon/avod/clickstream/SubPageType;
.super Ljava/lang/Object;
.source "SubPageType.java"

# interfaces
.implements Lcom/amazon/avod/clickstream/ClickstreamParam;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/avod/clickstream/SubPageType$SubPageContentType;
    }
.end annotation


# static fields
.field public static final EMPTY:Lcom/amazon/avod/clickstream/SubPageType;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    new-instance v0, Lcom/amazon/avod/clickstream/SubPageType$1;

    invoke-direct {v0}, Lcom/amazon/avod/clickstream/SubPageType$1;-><init>()V

    sput-object v0, Lcom/amazon/avod/clickstream/SubPageType;->EMPTY:Lcom/amazon/avod/clickstream/SubPageType;

    return-void
.end method
