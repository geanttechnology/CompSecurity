.class public Ltv/freewheel/utils/renderer/ParamParser;
.super Ljava/lang/Object;
.source "ParamParser.java"


# instance fields
.field private context:Ltv/freewheel/renderers/interfaces/IRendererContext;

.field private logger:Ltv/freewheel/utils/Logger;

.field private paramNamespace:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ltv/freewheel/renderers/interfaces/IRendererContext;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Ltv/freewheel/renderers/interfaces/IRendererContext;
    .param p2, "paramNamespace"    # Ljava/lang/String;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    const/4 v0, 0x1

    invoke-static {p0, v0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;Z)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/utils/renderer/ParamParser;->logger:Ltv/freewheel/utils/Logger;

    .line 24
    iput-object p1, p0, Ltv/freewheel/utils/renderer/ParamParser;->context:Ltv/freewheel/renderers/interfaces/IRendererContext;

    .line 25
    iput-object p2, p0, Ltv/freewheel/utils/renderer/ParamParser;->paramNamespace:Ljava/lang/String;

    .line 26
    return-void
.end method
