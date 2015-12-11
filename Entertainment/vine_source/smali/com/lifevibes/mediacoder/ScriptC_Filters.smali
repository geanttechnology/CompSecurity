.class public Lcom/lifevibes/mediacoder/ScriptC_Filters;
.super Ljava/lang/Object;
.source "ScriptC_Filters.java"


# instance fields
.field private _output:Landroid/support/v8/renderscript/Allocation;


# direct methods
.method public constructor <init>(Landroid/support/v8/renderscript/RenderScript;)V
    .locals 0
    .param p1, "mRenderScript"    # Landroid/support/v8/renderscript/RenderScript;

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    return-void
.end method


# virtual methods
.method public forEach_RGB888YUV444(Landroid/support/v8/renderscript/Allocation;)V
    .locals 0
    .param p1, "ain"    # Landroid/support/v8/renderscript/Allocation;

    .prologue
    .line 22
    return-void
.end method

.method public forEach_YUV444ToYUV420(Landroid/support/v8/renderscript/Allocation;)V
    .locals 0
    .param p1, "ain4"    # Landroid/support/v8/renderscript/Allocation;

    .prologue
    .line 39
    return-void
.end method

.method public forEach_YUV444ToYUV420SemiPlanar(Landroid/support/v8/renderscript/Allocation;)V
    .locals 0
    .param p1, "ain4"    # Landroid/support/v8/renderscript/Allocation;

    .prologue
    .line 43
    return-void
.end method

.method public forEach_YUVPackedToPlanar(Landroid/support/v8/renderscript/Allocation;Landroid/support/v8/renderscript/Allocation;)V
    .locals 0
    .param p1, "ain"    # Landroid/support/v8/renderscript/Allocation;
    .param p2, "aout"    # Landroid/support/v8/renderscript/Allocation;

    .prologue
    .line 34
    return-void
.end method

.method public get_output()Landroid/support/v8/renderscript/Allocation;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/lifevibes/mediacoder/ScriptC_Filters;->_output:Landroid/support/v8/renderscript/Allocation;

    return-object v0
.end method

.method public set_input(Landroid/support/v8/renderscript/Allocation;)V
    .locals 0
    .param p1, "ain2"    # Landroid/support/v8/renderscript/Allocation;

    .prologue
    .line 18
    return-void
.end method

.method public set_output(Landroid/support/v8/renderscript/Allocation;)V
    .locals 0
    .param p1, "_output"    # Landroid/support/v8/renderscript/Allocation;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/lifevibes/mediacoder/ScriptC_Filters;->_output:Landroid/support/v8/renderscript/Allocation;

    .line 26
    return-void
.end method

.method public set_output1(Landroid/support/v8/renderscript/Allocation;)V
    .locals 0
    .param p1, "ain3"    # Landroid/support/v8/renderscript/Allocation;

    .prologue
    .line 51
    return-void
.end method

.method public set_output2(Landroid/support/v8/renderscript/Allocation;)V
    .locals 0
    .param p1, "ain4"    # Landroid/support/v8/renderscript/Allocation;

    .prologue
    .line 47
    return-void
.end method
