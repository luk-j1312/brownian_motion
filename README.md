# Brownian Motion Analysis

## Overview
This project implements a computational pipeline for analyzing **Brownian motion** from microscopy video data to estimate physical constants, including **Avogadro’s number**.

Using image sequences of microscopic beads suspended in water, the system detects particles, tracks their motion across frames, and analyzes displacement statistics using Einstein’s diffusion model.

## Approach
The project consists of three stages:

1. **Particle identification** from noisy microscopy images  
2. **Particle tracking** across consecutive frames  
3. **Statistical analysis** of displacement data  

Beads are detected by converting each image to luminance values, applying intensity thresholding, and identifying connected foreground components representing particles.

## Implementation Details
Particle detection is performed using **connected-component analysis**, where sufficiently large blobs are classified as beads and represented by their centers of mass.

Detected particles are then matched between frames to measure displacement over time. These displacement measurements are used to estimate diffusion behavior and fit **Einstein’s model of Brownian motion**, enabling inference of microscopic physical parameters.

## Concepts Used
- Image processing and thresholding  
- Connected-components  
- Particle tracking  
- Diffusion physics  
- Scientific computing  

## Purpose
This assignment demonstrates how computational methods can bridge computer vision, statistical inference, and physics to extract meaningful scientific measurements from experimental data.
